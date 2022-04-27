package com.doestheohavethisbook;

import kong.unirest.json.JSONArray;
import org.junit.Test;

import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooksTests {
    @Test
    public void whenICallGetBooks_thenReturnsSeededTestBooks() {
        Map<String, Object> firstBook = new HashMap<>();
        Map<String, Object> secondBook = new HashMap<>();
        firstBook.put("title", "Clean Code");
        secondBook.put("title", "The Clean Coder");
        JSONArray response = Unirest.get("http://localhost:8080/books")
                .asJson()
                .getBody()
                .getArray();

        Map<String, Object> actualFirstBook = response.getJSONObject(0).toMap();
        Map<String, Object> actualSecondBook = response.getJSONObject(1).toMap();
        assertEquals(firstBook.get("title"), actualFirstBook.get("title"));
        assertEquals(secondBook.get("title"), actualSecondBook.get("title"));
    }
}
