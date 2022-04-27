package com.doestheohavethisbook.controllers

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.springframework.http.HttpStatus

class HelloControllerTests {
    @Test
    fun whenHelloCalled_thenReturnsHelloWorld() {
        val controller = HelloController()
        val result = controller.hello()

        assertEquals(HttpStatus.OK, result.getStatusCode())
        assertEquals("Hello, World!", result.getBody())
    }
}
