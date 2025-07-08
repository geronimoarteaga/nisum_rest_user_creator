package com.nisum.cl.springboot.rest.usercreation.dtos;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public final class ErrorResponse
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensaje;
}
