package com.team.housebackapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.housebackapi.entity.House;
import com.team.housebackapi.entity.HouseCondition;
import com.team.housebackapi.entity.Users;
import com.team.housebackapi.service.HouseService;
import com.team.housebackapi.util.BaseResult;
import com.team.housebackapi.util.FileUploadUtil;
import com.team.housebackapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/house/")
public class HouseController {

    @Autowired(required = false)
    private HouseService houseService;

    @RequestMapping("fabuHouse")
    public BaseResult fabuHouse(
            House house, HttpSession session,
            @RequestParam(value="pfile",required=false) MultipartFile pfile){
        //1.实现文件上传
        //主要:将上传的文件保存到文件服务器中（d://images充当服务器）
        try{
            String path = "D:\\images";
            String fileName = FileUploadUtil.upload(pfile,path);
            System.out.println("上传文件成功");
            //设置出租房编号随机
            house.setId(System.currentTimeMillis()+"");
            //设置用户id
            Users users = (Users) session.getAttribute("logininfo");
            house.setUserId(users.getId());
            //2.将信息入库
            house.setPath(fileName);
            house.setIsdel(0);
            houseService.addHouse(house);
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResult(BaseResult.RESULT_FAIL,"发布失败"+e.getMessage());
        }

    }

    //获取用户出租房信息
    @RequestMapping("getHouseByPage")
    public BaseResult getHouseByPage(PageParmeter pageParmeter,HttpSession session){
        Integer userid;
        //调用业务获取分页信息
        Users users = (Users) session.getAttribute("logininfo");
        if (users == null){
            userid = 1007;
        }else {
            userid = users.getId();
        }
        PageInfo<House> pageinfo = this.houseService.getHouseByUser(userid, pageParmeter);
        //返回总页数，当前页的数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("totalPage",pageinfo.getPages());
        map.put("row",pageinfo.getList());
        return new BaseResult(200,map);
    }

    @RequestMapping("delHouse")
    public BaseResult delHouse(String id){
        int temp = this.houseService.deleteHouse(id, 1);
        if (temp>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"删除失败");
        }

    }

    @RequestMapping("searchHouse")
    public BaseResult searchHouse(HouseCondition houseCondition){
        PageInfo<House> pageInfo = this.houseService.getBroswerHouse(houseCondition);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("curPage",pageInfo.getPageNum());
        map.put("totalPage",pageInfo.getPages());
        map.put("list",pageInfo.getList());
        return new BaseResult(200,map);
    }
}
