package dev.ingeb.bookshelf.stores;

import dev.ingeb.bookshelf.models.Book;
import org.dalesbred.Database;

import java.util.List;
import java.util.Optional;

public class BookStore {
    private final Database database;

    public BookStore(Database database) {
        this.database = database;
    }

    public Book createBook(Book book) {
        database.update("""
                INSERT INTO Books
                (bookId, title, author, smallPicture, largePicture, releaseYear, issn, publisher, pages)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """, book.getBookId(), book.getTitle(),
                book.getAuthor(), book.getSmallPicture(), book.getLargePicture(),
                book.getReleaseYear(), book.getIssn(), book.getPublisher(), book.getPages());
        return book;
    }

    public Optional<Book> getBook(String bookId) {
        return database.findOptional(Book.class, """
                SELECT * FROM Books
                WHERE bookId = ?
                """, bookId
        );
    }

    public void updateBook(Book book) {
        var bookId = book.getBookId();
        database.update("""
                UPDATE Books
                SET bookId = COALESCE(?, bookId), title = COALESCE(?, title),
                author = COALESCE(?, author), smallPicture = COALESCE(?, smallPicture), largePicture = COALESCE(?, largePicture),
                releaseYear = COALESCE(?, releaseYear), issn = COALESCE(?, issn), publisher = COALESCE(?, publisher)
                pages = COALESCE(?, pages)
                WHERE bookId = ?
                """, bookId, book.getTitle(),
                book.getAuthor(), book.getSmallPicture(), book.getLargePicture(),
                book.getReleaseYear(), book.getIssn(), book.getPublisher(), book.getPages(),
                bookId
        );
    }

    public void deleteBook(String bookId) {
        database.update("""
                DELETE FROM Books WHERE bookId = ?
                """,
                bookId
        );
    }

    public List<Book> getAllBooks() {
        return database.findAll(Book.class, """
                SELECT *
                FROM Books
                """
        );
    }
}