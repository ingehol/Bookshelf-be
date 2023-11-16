package dev.ingeb.bookshelf.services;

import dev.ingeb.bookshelf.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBook(String bookId);
    void updateBook(Book book);
    void deleteBook(String bookId);
    List<Book> getAllBooks();
}
