package com.nisum.cl.springboot.rest.usercreation.controller;

import com.nisum.cl.springboot.rest.usercreation.dtos.ErrorResponse;
import com.nisum.cl.springboot.rest.usercreation.dtos.UserRequestDTO;
import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;
import com.nisum.cl.springboot.rest.usercreation.exceptions.UserEmailExistException;
import com.nisum.cl.springboot.rest.usercreation.services.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService userInfoService;

    private final PasswordEncoder encoder;

    @Operation(summary = "Listar usuarios creados", description = "Se reequiere un token JWT para esta operación")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(path = "/users", produces = {"application/json"})
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return ResponseEntity.ok().body(userInfoService.getAll());
    }

    @Operation(summary = "Crear un usuario nuevo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario creado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserInfo.class)
                    )),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Server Error")})

    @PostMapping(path = "/users", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<UserInfo> createUser(@RequestBody @Valid UserRequestDTO userDTO) {
        try {
            userDTO.setPassword(encoder.encode(userDTO.getPassword()));
            return new ResponseEntity<>(userInfoService.create(userDTO), HttpStatus.CREATED);
        } catch (Exception exception) {
            throw new UserEmailExistException("Correo ya registrado");
        }
    }

}
