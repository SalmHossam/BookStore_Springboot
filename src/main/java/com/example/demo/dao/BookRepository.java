package com.example.demo.dao;

import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByCategory(String category);
    List<Book> findByRating(int rating);

}
