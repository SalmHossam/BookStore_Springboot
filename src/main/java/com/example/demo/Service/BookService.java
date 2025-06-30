package com.example.demo.Service;

import com.example.demo.Entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(long id);

    List<Book> findByTitle(String title);

    List<Book> findByRate(int rating);

    List<Book> findByCategory(String category);



    Book save(Book book);

    void deleteById(long id);


}
