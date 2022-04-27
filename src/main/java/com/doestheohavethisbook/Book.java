package com.doestheohavethisbook;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private UUID id;

    public Book(String title, UUID authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    @Column
    private String title;

    @Column(name = "author_id")
    private UUID authorId;

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(authorId, book.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorId);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
