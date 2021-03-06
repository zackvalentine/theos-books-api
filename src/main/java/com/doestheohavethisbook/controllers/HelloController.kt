package com.doestheohavethisbook.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {
    @CrossOrigin
    @GetMapping
    fun hello(): ResponseEntity<String> {
        return ResponseEntity("Hello, World!", HttpStatus.OK)
    }
}
