package com.doestheohavethisbook.controllers

import com.doestheohavethisbook.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.springframework.http.HttpStatus

import java.util.UUID

class AuthorsControllerTests {
    private val authorService = mockk<AuthorService>()

    private val controller = AuthorsController()

    @Test
    fun whenGetBooksCalled_thenCallsService() {
        val author1 = Author(UUID.randomUUID(), "Bob", "Martin")
        val author2 = Author(UUID.randomUUID(), "Martin", "Fowler")
        val expectedAuthors = listOf(author1, author2)
        every {authorService.getAllAuthors() }
            .returns(expectedAuthors)
        controller.authorService = authorService

        val result = controller.getAllAuthors()

        assertEquals(HttpStatus.OK, result.getStatusCode())
        assertEquals(expectedAuthors, result.getBody())
        verify { authorService.getAllAuthors() }
    }
}
