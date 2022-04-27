package com.doestheohavethisbook.controllers

import com.doestheohavethisbook.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.springframework.http.HttpStatus

import java.util.UUID

internal class BooksControllerTests {
    private val bookService = mockk<BookService>()

    private val controller = BooksController()

    @Test
    fun whenGetBooksCalled_thenCallsService() {
        val author = Author(UUID.randomUUID(), "Kent", "Beck")
        val book1 = Book(UUID.randomUUID(), "Test Book", author)
        val book2 = Book(UUID.randomUUID(), "Second Book", author)
        val expectedBooks = listOf(book1, book2)
        every { bookService.getAllBooks() }
            .returns(expectedBooks)
        controller.bookService = bookService

        val result = controller.getAllBooks()

        assertEquals(HttpStatus.OK, result.getStatusCode())
        assertEquals(expectedBooks, result.getBody())
        verify { bookService.getAllBooks() }
    }
}
