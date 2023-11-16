package dev.ingeb.bookshelf.controllers;

import dev.ingeb.bookshelf.contracts.BookshelfResponse;
import dev.ingeb.bookshelf.models.Book;
import dev.ingeb.bookshelf.services.BookService;
import dev.ingeb.bookshelf.services.BookshelfService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookshelf")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class BookshelfController {
    private BookService bookService;
    private BookshelfService bookShelfService;
    private static final Logger log = LoggerFactory.getLogger(BookshelfController.class);

    @PostMapping("/add")
    public void addToBookshelf(
            @RequestParam String userId,
            @RequestBody Book book
    ) {
        try {
            if(bookService.getBook(book.getBookId()) == null) {
                bookService.createBook(book);
            }
            bookShelfService.addToBookshelf(Long.parseLong(userId), book.getBookId());
        } catch (Exception e) {
            log.info(String.format("Could not add to library, exception: %s", e.getMessage()));
        }
    }

    @PutMapping("/setFavorite")
    public void setFavorite(
            @RequestParam("userId") String userId,
            @RequestParam("bookId") String bookId,
            @RequestParam("isFavorite") boolean isFavorite
    ) {
        bookShelfService.setFavorite(Long.parseLong(userId), bookId, isFavorite);
    }

    @PutMapping("/setRead")
    public void setRead(
            @RequestParam("userId") String userId,
            @RequestParam("bookId") String bookId,
            @RequestParam("hasRead") boolean hasRead
    ) {
        bookShelfService.setRead(Long.parseLong(userId), bookId, hasRead);
    }

    @DeleteMapping("/delete")
    public void deleteBookFromBookshelf (
            @RequestParam("userId") String userId,
            @RequestParam("bookId") String bookId
    ) {
        bookShelfService.deleteBookFromBookshelf(Long.parseLong(userId), bookId);
    }

    @GetMapping("/getLibrary")
    public List<BookshelfResponse> allBooks(@RequestParam String userId) {
        return bookShelfService.getBookshelf(Long.parseLong(userId));
    }
}
