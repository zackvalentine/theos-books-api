package com.doestheohavethisbook

import junit.framework.TestCase.assertEquals
import org.junit.Test

import kong.unirest.HttpStatus
import kong.unirest.Unirest

internal class HelloWorldTests {
    @Test
    fun whenICallHello_thenReturnsHelloWorld() {
        val response = Unirest.get("http://localhost:8080/hello").asString()

        assertEquals(HttpStatus.OK, response.getStatus())
        assertEquals("Hello, World!", response.getBody())
    }
}
