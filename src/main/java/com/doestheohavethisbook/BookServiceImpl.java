package com.doestheohavethisbook;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getAllBooks() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");
        return List.of(book1, book2);
    }
}
