package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByRate(int rating) {
        return bookRepository.findByRating(rating);
    }

    @Override
    public List<Book> findByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository){
        bookRepository=theBookRepository;

    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        Optional<Book> Result= bookRepository.findById(id);
        Book theBook=null;
        if(Result.isPresent()){
            theBook=Result.get();
        }
        else{
            throw new RuntimeException("There is no Book with this ID");
        }
        return theBook;
    }

    @Override
    public Book save(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);

    }
}
