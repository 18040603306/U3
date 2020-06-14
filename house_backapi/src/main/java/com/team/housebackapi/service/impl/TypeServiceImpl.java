package com.team.housebackapi.service.impl;

import com.team.housebackapi.entity.Type;
import com.team.housebackapi.entity.TypeExample;
import com.team.housebackapi.mapper.TypeMapper;
import com.team.housebackapi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired(required = false)
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllType() {
        return this.typeMapper.selectByExample(new TypeExample());
    }
}
