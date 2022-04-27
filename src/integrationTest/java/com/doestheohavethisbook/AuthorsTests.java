package com.doestheohavethisbook;

import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorsTests {
    @Test
    public void whenICallGetAuthors_thenReturnsSeededTestAuthor() {
        Map<String, Object> firstAuthor = new HashMap<>();
        firstAuthor.put("firstName", "Bob");
        firstAuthor.put("lastName", "Martin");
        JSONArray response = Unirest.get("http://localhost:8080/authors")
                .asJson()
                .getBody()
                .getArray();

        Map<String, Object> actualFirstAuthor = response.getJSONObject(0).toMap();
        assertEquals(firstAuthor.get("firstName"), actualFirstAuthor.get("firstName"));
        assertEquals(firstAuthor.get("lastName"), actualFirstAuthor.get("lastName"));
    }
}
