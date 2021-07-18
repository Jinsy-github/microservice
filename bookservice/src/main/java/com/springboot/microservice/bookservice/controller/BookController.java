package com.springboot.microservice.bookservice.controller;

import com.springboot.microservice.bookservice.dto.Response;
import com.springboot.microservice.bookservice.entity.Book;
import com.springboot.microservice.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public Book save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Response getBookById(@PathVariable("id") Long bookId) {
        return bookService.getBookWithUserDetails(bookId);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);
    }

    @PutMapping("/")
    public Book update(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
}
