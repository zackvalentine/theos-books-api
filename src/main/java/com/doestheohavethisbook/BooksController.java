package com.doestheohavethisbook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");

        return new ResponseEntity<>(List.of(book1, book2), HttpStatus.OK);
    }
}
