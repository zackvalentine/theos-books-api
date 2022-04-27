package com.doestheohavethisbook

import junit.framework.TestCase.assertEquals
import org.junit.Test

import kong.unirest.Unirest

import java.util.HashMap

internal class BooksTests {
    @Test
    fun whenICallGetBooks_thenReturnsSeededTestBooks() {
        val firstBook = HashMap<String, Any>()
        val secondBook = HashMap<String, Any>()
        firstBook["title"] = "Clean Code"
        secondBook["title"] = "The Clean Coder"
        val response = Unirest.get("http://localhost:8080/books")
                .asJson()
                .body
                .array

        val actualFirstBook = response.getJSONObject(0).toMap()
        val actualSecondBook = response.getJSONObject(1).toMap()
        assertEquals(firstBook["title"], actualFirstBook["title"])
        assertEquals(secondBook["title"], actualSecondBook["title"])
    }
}
