package com.doestheohavethisbook.controllers

import com.doestheohavethisbook.Author
import com.doestheohavethisbook.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class AuthorsController {
    @Autowired
    lateinit var authorService: AuthorService

    @GetMapping
    fun getAllAuthors(): ResponseEntity<List<Author>> {
        return ResponseEntity(authorService.getAllAuthors(), HttpStatus.OK)
    }
}
