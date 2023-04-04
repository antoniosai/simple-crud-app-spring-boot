package com.antoniosai.crud.modules.book;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(produces = "application/json")
    public List<BookEntity> getBooks() {
        return this.bookService.getBooks();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{bookId}")
    public ResponseEntity<BookEntity> getStudentById(@PathVariable("bookId") @Valid Long bookId) {
        BookEntity book = bookService.getBookById(bookId);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json")
    public ResponseEntity<BookEntity> saveNewBook(@Valid @RequestBody BookEntity book) {
        System.out.println("Book => " + book);
        BookEntity newBook = this.bookService.saveBook(book);

        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{bookId}")
    public ResponseEntity<BookEntity> getStudentById(@PathVariable("bookId") @Valid Long bookId, @Valid @RequestBody BookEntity book) {
        BookEntity updatedBook = bookService.updateBook(book, bookId);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> dropBook(@PathVariable("bookId") @Valid Long bookId) {
        String deleteMessage = bookService.destroyBook(bookId);

        return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
    }
}
