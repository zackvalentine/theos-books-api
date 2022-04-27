package com.doestheohavethisbook

import javax.persistence.*
import java.util.UUID

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    val id: UUID = UUID.randomUUID(),
    @Column(name = "first_name")
    val firstName: String = "Test",
    @Column(name = "last_name")
    val lastName: String = "Author"
)
