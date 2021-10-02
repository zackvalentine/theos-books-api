package com.doestheohavethisbook;

import org.json.JSONArray;
import org.junit.Test;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksTests {
    @Test
    public void whenICallGetBooks_thenReturnsHardcodedBooks() {
        IntegrationTestBook integrationTestBook1 = new IntegrationTestBook("Test Book", "Test Author");
        IntegrationTestBook integrationTestBook2 = new IntegrationTestBook("Second Book", "Another Author");
        List<IntegrationTestBook> expectedIntegrationTestBooks = List.of(integrationTestBook1, integrationTestBook2);
        JSONArray response = Unirest.get("http://localhost:8080/books")
                .asJson()
                .getBody()
                .getArray();

        assertThat(response, is(expectedIntegrationTestBooks));
    }
}
