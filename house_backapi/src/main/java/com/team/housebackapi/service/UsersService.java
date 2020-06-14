package com.team.housebackapi.service;

import com.team.housebackapi.entity.Users;

public interface UsersService {

    //注册用户
    public int regUser(Users users);

    public Users Login(String username,String password);
}
