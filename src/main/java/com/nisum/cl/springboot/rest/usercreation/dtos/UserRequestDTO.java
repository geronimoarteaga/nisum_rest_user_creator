package com.nisum.cl.springboot.rest.usercreation.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class UserRequestDTO
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @Email(message = "Correo no válido, debe tener el formato correcto: aaaaaaa@dominio.cl")
    private String email;

    @Pattern(regexp = "^(?=(?:.*[A-Z]){1})(?=(?:.*[a-z]){1})(?=(?:.*\\d){2})\\S{4,}$", message = "Clave no válida, debe tener: una Mayúscula, letras minúsculas, y dos números")
    private String password;

    @Builder.Default
    private List<PhoneRequestDTO> phones = new ArrayList<>();
}
