package com.nisum.cl.springboot.rest.usercreation.services;

import java.util.List;

import com.nisum.cl.springboot.rest.usercreation.dtos.UserRequestDTO;
import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;

public interface UserInfoService {
    
    List<UserInfo> getAll();

    UserInfo create(UserRequestDTO userDTO);

    UserInfo findByUsername(String email);

}
