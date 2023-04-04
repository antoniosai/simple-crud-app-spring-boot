package com.antoniosai.crud.modules.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getBooks() {
        return this.bookRepository.findAll();
    }

    public BookEntity getBookById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    public BookEntity saveBook(BookEntity book) {
        return this.bookRepository.saveAndFlush(book);
    }

    public BookEntity updateBook(BookEntity book, Long id) {
        BookEntity bookToBeUpdated = this.bookRepository.findById(id).orElse(null);

        if (bookToBeUpdated != null) {
            book.setId(id);

            bookRepository.save(book);
        }
        return bookToBeUpdated;
    }

    public String destroyBook(Long id) {
        this.bookRepository.deleteById(id);

        return "Successfully deleted a Book";
    }
}
