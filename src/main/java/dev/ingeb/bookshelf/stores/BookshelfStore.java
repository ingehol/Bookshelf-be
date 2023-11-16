package dev.ingeb.bookshelf.stores;

import dev.ingeb.bookshelf.contracts.BookshelfResponse;
import org.dalesbred.Database;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookshelfStore {
    private final Database database;

    public BookshelfStore(Database database) {
        this.database = database;
    }

    public void addToBookshelf(Long userId, String bookId) {
        database.update("""
                INSERT INTO Library
                (userId, bookId, isFavorite, hasRead, readDate)
                VALUES (?, ?, ?, ?, ?)
                """, userId, bookId, false, false, null);
    }

    public Optional<BookshelfResponse> getBookshelfResponse(Long userId, String bookId) {
        return database.findOptional(BookshelfResponse.class, """
                SELECT *
                FROM Library
                WHERE userId = ? AND bookId = ?
                """, userId, bookId
        );
    }

    public void setFavorite(Long userId, String bookId, boolean isFavorite) {
        database.update("""
                UPDATE Library
                SET isFavorite = COALESCE(?, isFavorite)
                WHERE userId = ? AND bookId = ?
                """,
                isFavorite,
                userId, bookId
        );
    }

    public void setRead(Long userId, String bookId, boolean hasRead) {
        database.update("""
                UPDATE Library
                SET hasRead = COALESCE(?, hasRead), readDate = COALESCE(?, readDate)
                WHERE userId = ? AND bookId = ?
                """,
                hasRead, hasRead ? LocalDate.now() : null,
                userId, bookId
        );
    }

    public void deleteBookFromBookshelf(Long userId, String bookId) {
        database.update("""
                DELETE FROM Library WHERE userId = ? AND bookId = ?
                """,
                userId, bookId
        );
    }

    public List<BookshelfResponse> getBookshelf(Long userId) {
        return database.findAll(BookshelfResponse.class, """
                SELECT l.userId, l.isFavorite, l.hasRead, l.readDate, b.bookId, b.title, b.author, b.smallPicture, b.largePicture, b.releaseYear, b.issn, b.publisher, b.pages
                FROM Library l
                JOIN Books b on b.bookId = l.bookId
                WHERE userId = ?
                """, userId
        );
    }
}
