package com.doestheohavethisbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) repository.findAll();
    }
}
