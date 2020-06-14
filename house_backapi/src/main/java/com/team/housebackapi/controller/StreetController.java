package com.team.housebackapi.controller;

import com.team.housebackapi.entity.Street;
import com.team.housebackapi.service.StreetService;
import com.team.housebackapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/str/")
public class StreetController {

    @Autowired(required = false)
    private StreetService streetService;

    @RequestMapping("getStreetDataById")
    public BaseResult getStreetDataById(Integer did){
        List<Street> list = streetService.getStreetsById(did);
        return new BaseResult(200,list);
    }
}
