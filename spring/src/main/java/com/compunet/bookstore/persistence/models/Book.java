package com.compunet.bookstore.persistence.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, Date releaseDate, Author author){
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAutor() {
        return author;
    }

    public void setAutor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book(id: " + id + "; title: " + title + "; release date: " + releaseDate + "; author: " + author.getName() + ")";
    }

}
