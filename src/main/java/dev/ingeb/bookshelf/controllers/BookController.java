package dev.ingeb.bookshelf.controllers;

import dev.ingeb.bookshelf.models.Book;
import dev.ingeb.bookshelf.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/book")
    public Book getBook(@RequestParam String bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/delete")
    public void deleteBook (@RequestParam String bookId) {
        bookService.deleteBook(bookId);
    }

    @GetMapping("/allBooks")
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }
}
