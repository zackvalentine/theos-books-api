package com.doestheohavethisbook

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import java.util.UUID

@Repository
interface AuthorRepository : CrudRepository<Author, UUID>
