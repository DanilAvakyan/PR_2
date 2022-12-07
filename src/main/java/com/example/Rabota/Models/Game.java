package com.example.Rabota.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private float price;
    private String developer;
    private String genre;
    private String publisher;
    private String specifications;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}


    public float getPrice() {return price;}

    public void setPrice(float price) {this.price = price;}


    public String getDeveloper() {return developer;}

    public void setDeveloper(String developer) {this.developer = developer;}


    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}


    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}


    public String getSpecifications() {return specifications;}

    public void setSpecifications(String specifications) {this.specifications = specifications;}


    public Game() {}

    public Game(String name, float price, String developer, String genre, String publisher, String specifications) {
        this.name = name;
        this.price = price;
        this.developer = developer;
        this.genre = genre;
        this.publisher = publisher;
        this.specifications = specifications;
    }


}
