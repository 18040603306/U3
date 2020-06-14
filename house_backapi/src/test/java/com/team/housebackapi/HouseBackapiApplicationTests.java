package com.team.housebackapi;

import com.team.housebackapi.entity.DistrictExample;
import com.team.housebackapi.mapper.DistrictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseBackapiApplicationTests {

    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @Test
    public void contextLoads() {
        System.out.println("测试:"+this.districtMapper.selectByExample(new DistrictExample()).size());
    }

}
