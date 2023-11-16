package dev.ingeb.bookshelf.services;

import dev.ingeb.bookshelf.contracts.BookshelfResponse;
import dev.ingeb.bookshelf.stores.BookshelfStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfServiceImplementation implements BookshelfService {

    private final BookshelfStore bookshelfStore;
    private static final Logger log = LoggerFactory.getLogger(BookshelfServiceImplementation.class);


    public BookshelfServiceImplementation(BookshelfStore bookshelfStore) {
        this.bookshelfStore = bookshelfStore;
    }

    @Override
    public void addToBookshelf(Long userId, String bookId) {
        if(bookshelfStore.getBookshelfResponse(userId, bookId).isEmpty()) {
            bookshelfStore.addToBookshelf(userId, bookId);
        } else {
            log.error(String.format("Book already exists in library for userId %s and bookId %s", userId, bookId));
        }
    }

    @Override
    public BookshelfResponse getBookshelfResponse(Long userId, String bookId) {
        return bookshelfStore.getBookshelfResponse(userId, bookId).orElse(null);
    }

    @Override
    public void setFavorite(Long userId, String bookId, boolean isFavorite) {
        bookshelfStore.setFavorite(userId, bookId, isFavorite);
    }

    @Override
    public void setRead(Long userId, String bookId, boolean hasRead) {
        bookshelfStore.setRead(userId, bookId, hasRead);
    }

    @Override
    public void deleteBookFromBookshelf(Long userId, String bookId) {
        bookshelfStore.deleteBookFromBookshelf(userId, bookId);
    }

    @Override
    public List<BookshelfResponse> getBookshelf(Long userId) {
        try {
            return bookshelfStore.getBookshelf(userId);
        } catch (Exception e) {
            log.error(String.format("Error %s", e.getMessage()));
            e.printStackTrace();
        }
        return null;
    }
}
