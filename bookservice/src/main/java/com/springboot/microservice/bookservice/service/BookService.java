package com.springboot.microservice.bookservice.service;

import com.springboot.microservice.bookservice.dto.Response;
import com.springboot.microservice.bookservice.dto.User;
import com.springboot.microservice.bookservice.entity.Book;
import com.springboot.microservice.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    public Response getBookWithUserDetails(Long bookId) {
        Book book = bookRepository.findById(bookId).get();
        Response res = new Response();
        User user= restTemplate.getForObject("http://USERSERVICE/users/"+ book.getUserId(), User.class);
        res.setBook(book);
        res.setUser(user);

        return res;
    }

    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book updateBook(Book book) {

        Book book1 = bookRepository.findById(book.getId()).get();
        if(Objects.nonNull(book1.getName())){
            book1.setName(book.getName());
        }
        return bookRepository.save(book1);
    }
}
