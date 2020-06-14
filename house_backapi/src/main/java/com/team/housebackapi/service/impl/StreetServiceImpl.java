package com.team.housebackapi.service.impl;

import com.team.housebackapi.entity.Street;
import com.team.housebackapi.entity.StreetExample;
import com.team.housebackapi.mapper.StreetMapper;
import com.team.housebackapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired(required = false)
    private StreetMapper streetMapper;

    @Override
    public List<Street> getStreetsById(Integer did) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        return streetMapper.selectByExample(streetExample);
    }
}
