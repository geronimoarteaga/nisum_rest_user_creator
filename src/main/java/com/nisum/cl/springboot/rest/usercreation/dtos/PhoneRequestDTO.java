package com.nisum.cl.springboot.rest.usercreation.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class PhoneRequestDTO
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;
    private String citycode;
    private String contrycode;
}
