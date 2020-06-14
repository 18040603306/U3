package com.team.housebackapi.service;

import com.github.pagehelper.PageInfo;
import com.team.housebackapi.entity.House;
import com.team.housebackapi.entity.HouseCondition;
import com.team.housebackapi.util.PageParmeter;

public interface HouseService {

    //发布出租房
    public int addHouse(House house);

    //查询某用户下的出租房
    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter);

    public int deleteHouse(String id,Integer delState);

    //浏览出租房
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition);
}
