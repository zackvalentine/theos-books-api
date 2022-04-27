package com.doestheohavethisbook

import junit.framework.TestCase.assertEquals
import kong.unirest.Unirest
import org.junit.Test

import java.util.HashMap

internal class AuthorsTests {
    @Test
    fun whenICallGetAuthors_thenReturnsSeededTestAuthor() {
        val firstAuthor = HashMap<String, Any>()
        firstAuthor["firstName"] = "Bob"
        firstAuthor["lastName"] = "Martin"
        val response = Unirest.get("http://localhost:8080/authors")
                .asJson()
                .body
                .array

        val actualFirstAuthor = response.getJSONObject(0).toMap()
        assertEquals(firstAuthor["firstName"], actualFirstAuthor["firstName"])
        assertEquals(firstAuthor["lastName"], actualFirstAuthor["lastName"])
    }
}
