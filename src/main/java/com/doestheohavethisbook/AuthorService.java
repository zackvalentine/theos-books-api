package com.doestheohavethisbook;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<Author> getAllAuthors();
}
