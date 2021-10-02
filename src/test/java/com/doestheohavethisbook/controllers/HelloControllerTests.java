package com.doestheohavethisbook.controllers;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;

public class HelloControllerTests {
    @Test
    public void whenHelloCalled_thenReturnsHelloWorld() {
        HelloController controller = new HelloController();
        ResponseEntity<String> result = controller.hello();

        assertThat(result.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(result.getBody(), is("Hello, World!"));
    }
}
