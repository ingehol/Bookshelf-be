package dev.ingeb.bookshelf.services;

import dev.ingeb.bookshelf.models.Book;
import dev.ingeb.bookshelf.stores.BookStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private final BookStore bookStore;
    private static final Logger log = LoggerFactory.getLogger(BookServiceImplementation.class);

    public BookServiceImplementation(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public Book createBook(Book book) {
        if(bookStore.getBook(book.getBookId()).isEmpty()) {
            return bookStore.createBook(book);
        }
        return null;
    }

    @Override
    public Book getBook(String bookId) {
        return bookStore.getBook(bookId).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        if(bookStore.getBook(book.getBookId()).isPresent()) {
            bookStore.updateBook(book);
        } else {
            log.error(String.format("Book does not exist for bookId %s", book.getBookId()));
        }
    }

    @Override
    public void deleteBook(String bookId) {
        if(bookStore.getBook(bookId).isPresent()) {
            bookStore.deleteBook(bookId);
        } else {
            log.error(String.format("Book does not exist for bookId %s", bookId));
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookStore.getAllBooks();
    }
}
