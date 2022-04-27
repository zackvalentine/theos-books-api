package com.doestheohavethisbook

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BooksController {
    @Autowired
    lateinit var bookService: BookService

    @CrossOrigin
    @GetMapping
    fun getAllBooks(): ResponseEntity<List<Book>> {
        return ResponseEntity(bookService.getAllBooks(), HttpStatus.OK)
    }
}
