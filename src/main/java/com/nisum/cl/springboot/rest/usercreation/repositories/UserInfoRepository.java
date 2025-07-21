package com.nisum.cl.springboot.rest.usercreation.repositories;

import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByEmail(String email);
}
