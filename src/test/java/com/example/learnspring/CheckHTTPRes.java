package com.example.learnspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckHTTPRes {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldPassIfStringMatches() {
        String res = this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertThat(res).isEqualTo("Hello World from Spring Boot");
    }
}
