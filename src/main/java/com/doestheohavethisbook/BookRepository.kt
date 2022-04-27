package com.doestheohavethisbook

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import java.util.UUID

@Repository
interface BookRepository : CrudRepository<Book, UUID>
