package com.doestheohavethisbook.controllers;

import com.doestheohavethisbook.Book;
import com.doestheohavethisbook.BooksController;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BooksControllerTests {
    @Test
    public void whenGetBooksCalled_thenReturnsHardCodedBooks() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");
        List<Book> expectedBooks = List.of(book1, book2);
        BooksController controller = new BooksController();
        ResponseEntity<List<Book>> result = controller.getAllBooks();

        assertThat(result.getStatusCode(), is(HttpStatus.OK));
        assertThat(result.getBody(), is(expectedBooks));
    }
}
