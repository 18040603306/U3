package com.team.housebackapi.controller;

import com.team.housebackapi.entity.Users;
import com.team.housebackapi.service.UsersService;
import com.team.housebackapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/regUser")
    public BaseResult regUser(Users users){
        //调用业务
        int i = usersService.regUser(users);
        if (i>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"注册成功");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"注册失败");
        }

    }

    @RequestMapping("/userLogin")
    public BaseResult userLogin(String username, String password, HttpSession session){
        Users users = usersService.Login(username, password);
        if (users==null){
            return new BaseResult(BaseResult.RESULT_FAIL,"用户名密码输入不正确");
        }else {
            session.setAttribute("logininfo",users);
            session.setMaxInactiveInterval(6000);
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }
    }
}
