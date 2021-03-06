package com.isanuric.movie.entity;

// import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "movie")
// @Cacheable
// @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message="Movie's 'name' cannot be null")
    private String name;

    @NotEmpty(message="Movie's 'author' cannot be null")
    private String author;

    @NotEmpty(message="Movie's 'regisseur' cannot be null")
    private String regisseur;

    public Movie() {
    }

    public Movie(String name, String author, String regisseur) {
        this.name = name;
        this.author = author;
        this.regisseur = regisseur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }
}
