package com.doestheohavethisbook

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test

import java.util.UUID

internal class AuthorServiceTests {
    private val repository = mockk<AuthorRepository>()

    @Test
    fun whenGetAllAuthorsCalled_thenCallsRepository() {
        val author1 = Author(UUID.randomUUID(), "Bob", "Martin")
        val author2 = Author(UUID.randomUUID(), "Martin", "Fowler")
        val expectedAuthors = listOf(author1, author2)
         every { repository.findAll() }
             .returns(expectedAuthors)
        val service = AuthorService()
        service.repository = repository

        val result = service.getAllAuthors()

        assertEquals(expectedAuthors, result)
        verify { repository.findAll() }
    }
}
