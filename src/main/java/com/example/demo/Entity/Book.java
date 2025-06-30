package com.example.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name = "books")
public class Book {

    @Id
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    private String title;
    private String author;
    private String category;
    private int rating;
}
