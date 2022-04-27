package com.doestheohavethisbook

import javax.persistence.*
import java.util.UUID

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    val id: UUID = UUID.randomUUID(),
    @Column
    val title: String = "Test Book",
    @ManyToOne
    @JoinColumn(name="author_id", nullable=true)
    val author: Author? = null
)
