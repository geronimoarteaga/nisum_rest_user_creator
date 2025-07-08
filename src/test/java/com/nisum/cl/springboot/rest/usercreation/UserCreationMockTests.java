package com.nisum.cl.springboot.rest.usercreation;

import com.nisum.cl.springboot.rest.usercreation.controller.UserController;
import com.nisum.cl.springboot.rest.usercreation.dtos.UserRequestDTO;
import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;
import com.nisum.cl.springboot.rest.usercreation.services.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserCreationMockTests {

    @Mock
    private UserInfoService userInfoService;

    @InjectMocks
    private UserController userController;

    @Test
    public void returnAllUserEmptySuccess() {
        // Given ...
        when(userInfoService.getAll())
                .thenReturn(new ArrayList<>());

        // When ...
        ResponseEntity<List<UserInfo>> response = userController.getAllUsers();

        // Then ...
        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .isEqualTo(new ArrayList<>());
    }

    @Test
    public void addNewUserSuccess() {
        // Given..
        UserRequestDTO userRequest = UserRequestDTO.builder().build();
        UserInfo userInfo = UserInfo.builder().build();

        when(userInfoService.create(userRequest))
                .thenReturn(userInfo);

        // When ...
        ResponseEntity<UserInfo> response = userController.createUser(userRequest);

        // Then ...
        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody())
                .isEqualTo(userInfo);
    }
}
