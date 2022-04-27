package com.doestheohavethisbook;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private UUID id;

    public Author(String firstName, String lastName, UUID authorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = authorId;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Author() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getAuthorId() {
        return id;
    }

    public void setAuthorId(UUID authorId) {
        this.id = authorId;
    }
}
