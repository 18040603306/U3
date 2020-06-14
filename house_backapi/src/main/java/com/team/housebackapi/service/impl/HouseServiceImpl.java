package com.team.housebackapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.housebackapi.entity.House;
import com.team.housebackapi.entity.HouseCondition;
import com.team.housebackapi.mapper.HouseMapper;
import com.team.housebackapi.service.HouseService;
import com.team.housebackapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter) {
        PageHelper.startPage(pageParmeter.getPage(),pageParmeter.getPageSize());
        List<House> list = houseMapper.getHouseByUser(userid);
        return new PageInfo<House>(list);
    }

    @Override
    public int deleteHouse(String id, Integer delState) {
        House house = new House();
        house.setId(id);
        house.setIsdel(delState);
        return this.houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        List<House> list = houseMapper.browserHouse(houseCondition);
        return new PageInfo<House>(list);
    }

}
