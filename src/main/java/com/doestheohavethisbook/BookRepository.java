package com.doestheohavethisbook;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    public List<Book> getAllBooks() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");

        return List.of(book1, book2);
    }
}

