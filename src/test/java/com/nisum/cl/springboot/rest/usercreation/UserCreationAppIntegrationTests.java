package com.nisum.cl.springboot.rest.usercreation;

import com.nisum.cl.springboot.rest.usercreation.dtos.UserRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration-test")
class UserCreationAppIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetEndpoint() {
        // When ...
        String response = restTemplate.getForObject("http://localhost:" + port + "/api/v1/users", String.class);

        // Then ...
        assertThat(response).contains("");
    }

    @Test
    public void testPostEndpointBadRequest() {
        // Given ...
        UserRequestDTO requestBody = UserRequestDTO.builder()
                .name("Juan Rodriguez")
                .email("juan@rodriguez.org")
                .password("Hunter3")
                .build();

        // When ...
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/users", requestBody, String.class);

        // Then ...
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testPostEndpointOK() {
        // Given ...
        UserRequestDTO requestBody = UserRequestDTO.builder()
                .name("Juan Rodriguez")
                .email("juan@rodriguez.org")
                .password("Hunter23")
                .build();

        // When ...
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/users", requestBody, String.class);

        // Then ...
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

}