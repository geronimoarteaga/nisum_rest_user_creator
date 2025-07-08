package com.nisum.cl.springboot.rest.usercreation;

import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;
import com.nisum.cl.springboot.rest.usercreation.repositories.UserInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserCreationAppDataTests {

    @Autowired
    private UserInfoRepository repositoryTest;

    @AfterEach
    void tearDown() {
        repositoryTest.deleteAll();
    }

    @Test
    void itShouldCheckIfAddNewUserSuccess() {

        // Given ...
        UserInfo user = UserInfo.builder()
                .name("Juan Rodriguez")
                .email("juan@rodriguez.org")
                .password("hunter2")
                .build();

        // When ...
        UserInfo created = repositoryTest.save(user);

        // Then ...
        assertThat(created.getCreated()).isEqualTo(created.getLastLogin());
        assertThat(created.getIsactive()).isTrue();
    }
}
