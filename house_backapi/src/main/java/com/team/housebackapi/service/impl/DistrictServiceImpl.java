package com.team.housebackapi.service.impl;

import com.team.housebackapi.entity.District;
import com.team.housebackapi.entity.DistrictExample;
import com.team.housebackapi.mapper.DistrictMapper;
import com.team.housebackapi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @Override
    public List<District> getAllDistrict() {
        return this.districtMapper.selectByExample(new DistrictExample());
    }
}
