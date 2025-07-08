package com.nisum.cl.springboot.rest.usercreation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    
}
