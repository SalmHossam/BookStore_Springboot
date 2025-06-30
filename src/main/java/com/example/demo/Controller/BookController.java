package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    private BookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/")
    @Operation(summary = "Get all books")
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by ID")
    public Book getBookById(@PathVariable long id) {
        return bookService.findById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Search books by ID, title, rating, or category")
    public List<Book> searchBooks(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) int rating,
            @RequestParam(required = false) String category
    ) {
        if (id != null) {
            return List.of(bookService.findById(id));
        }
        if (title != null) {
            return bookService.findByTitle(title);
        }
        if (rating != 0) {
            return bookService.findByRate(rating);
        }
        if (category != null) {
            return bookService.findByCategory(category);
        }
        return bookService.findAll();
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new book")
    public Book addBook(@RequestBody Book bookRequest){
        bookRequest.setId(0);
        return bookService.save(bookRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a book")
    public Book updateBook (@RequestBody Book bookRequest){
        Book theBook=bookService.save(bookRequest);
        return theBook;

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book")
        public String deleteBook(@PathVariable int id){
            Book theBook =bookService.findById(id);

            if(theBook==null){
                throw new RuntimeException("The Book with this Id "+id+"not found");
            }
            bookService.deleteById(id);

            return "The Book with Id "+id+"Deleted Successfully";
        }
    }
