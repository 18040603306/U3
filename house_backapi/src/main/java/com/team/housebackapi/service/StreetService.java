package com.team.housebackapi.service;

import com.team.housebackapi.entity.Street;

import java.util.List;

public interface StreetService {

    //查询街道
    public List<Street> getStreetsById(Integer id);
}
