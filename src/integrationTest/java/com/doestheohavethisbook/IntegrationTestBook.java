package com.doestheohavethisbook;

public class IntegrationTestBook {
    public IntegrationTestBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    private String title;

    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
