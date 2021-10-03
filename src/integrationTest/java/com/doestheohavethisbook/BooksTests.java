package com.doestheohavethisbook;

import org.json.JSONArray;
import org.junit.Test;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksTests {
    @Test
    public void whenICallGetBooks_thenReturnsHardcodedBooks() {
        Map<String, Object> firstBook = new HashMap<>();
        Map<String, Object> secondBook = new HashMap<>();
        firstBook.put("title", "Test Book");
        firstBook.put("author", "Test Author");
        secondBook.put("title", "Second Book");
        secondBook.put("author", "Another Author");
        JSONArray response = Unirest.get("http://localhost:8080/books")
                .asJson()
                .getBody()
                .getArray();

        Map<String, Object> actualFirstBook = response.getJSONObject(0).toMap();
        Map<String, Object> actualSecondBook = response.getJSONObject(1).toMap();
        assertThat(actualFirstBook, is(firstBook));
        assertThat(actualSecondBook, is(secondBook));
    }
}
