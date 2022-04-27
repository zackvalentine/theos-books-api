package com.doestheohavethisbook

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthorService {
    @Autowired
    lateinit var repository: AuthorRepository

    fun getAllAuthors(): List<Author>
        = repository.findAll().toList()
}
