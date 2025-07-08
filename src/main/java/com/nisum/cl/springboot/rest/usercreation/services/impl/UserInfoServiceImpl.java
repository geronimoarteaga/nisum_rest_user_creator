package com.nisum.cl.springboot.rest.usercreation.services.impl;

import com.nisum.cl.springboot.rest.usercreation.dtos.PhoneRequestDTO;
import com.nisum.cl.springboot.rest.usercreation.dtos.UserRequestDTO;
import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;
import com.nisum.cl.springboot.rest.usercreation.entities.UserPhone;
import com.nisum.cl.springboot.rest.usercreation.repositories.UserInfoRepository;
import com.nisum.cl.springboot.rest.usercreation.services.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl
        implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public List<UserInfo> getAll() {
        return new ArrayList<>(userInfoRepository.findAll());
    }

    public UserInfo create(UserRequestDTO userDTO) {
        UserInfo user = UserInfo.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
        for (PhoneRequestDTO phone : userDTO.getPhones()) {
            user.getPhones().add(UserPhone.builder()
                    .number(phone.getNumber())
                    .citycode(phone.getCitycode())
                    .contrycode(phone.getContrycode())
                    .build());
        }
        return userInfoRepository.save(user);
    }

}
