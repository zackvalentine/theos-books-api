package com.doestheohavethisbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>) repository.findAll();
    }
}
