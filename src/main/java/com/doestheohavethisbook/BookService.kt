package com.doestheohavethisbook

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService {
    @Autowired
    lateinit var repository: BookRepository

    fun getAllBooks(): List<Book> {
        return repository.findAll().toList()
    }
}
