package dev.ingeb.bookshelf.services;

import dev.ingeb.bookshelf.contracts.BookshelfResponse;

import java.util.List;

public interface BookshelfService {
    void addToBookshelf(Long userId, String bookId);
    BookshelfResponse getBookshelfResponse(Long userId, String bookId);
    void setFavorite(Long userId, String bookId, boolean isFavorite);
    void setRead(Long userId, String bookId, boolean hasRead);
    void deleteBookFromBookshelf(Long userId, String bookId);
    List<BookshelfResponse> getBookshelf(Long userId);
}
