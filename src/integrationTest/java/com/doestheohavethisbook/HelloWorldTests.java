package com.doestheohavethisbook;

import org.junit.Test;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloWorldTests {
    @Test
    public void whenICallHello_thenReturnsHelloWorld() {
        HttpResponse<String> response = Unirest.get("http://localhost:8080/hello").asString();

        assertThat(response.getStatus(), is(200));
        assertThat(response.getBody(), is("Hello, World!"));
    }
}
