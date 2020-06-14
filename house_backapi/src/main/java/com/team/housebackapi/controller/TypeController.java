package com.team.housebackapi.controller;

import com.team.housebackapi.entity.Type;
import com.team.housebackapi.service.TypeService;
import com.team.housebackapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type/")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/showAllType")
    public BaseResult showAllType(){
        List<Type> list = typeService.getAllType();
        return new BaseResult(200,list);
    }
}
