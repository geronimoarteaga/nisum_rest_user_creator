package com.nisum.cl.springboot.rest.usercreation.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public final class LoginRequestDTO
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;
}
