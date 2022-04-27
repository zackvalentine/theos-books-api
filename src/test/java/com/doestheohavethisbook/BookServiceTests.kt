package com.doestheohavethisbook

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test

import java.util.UUID

internal class BookServiceTests {
    private val repository = mockk<BookRepository>()

    private val service = BookService()

    @Test
    fun whenGetAllBooksCalled_thenCallsRepository() {
        val author = Author(UUID.randomUUID(), "Venkat", "Subramaniam")
        val book1 = Book(UUID.randomUUID(), "Test Book", author)
        val book2 = Book(UUID.randomUUID(), "Second Book", author)
        val expectedBooks = listOf(book1, book2)
        every {repository.findAll() }
            .returns(expectedBooks)
        service.repository = repository

        val result = service.getAllBooks()

        assertEquals(expectedBooks, result)
        verify {repository.findAll()}
    }
}
