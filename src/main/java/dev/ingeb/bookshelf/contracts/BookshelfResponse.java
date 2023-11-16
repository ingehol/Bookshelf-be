package dev.ingeb.bookshelf.contracts;

import dev.ingeb.bookshelf.models.Book;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookshelfResponse {
    private Long userId;
    private boolean isFavorite;
    private boolean hasRead;
    private LocalDate readDate;
    private Book book;

    public BookshelfResponse() {
    }

    public BookshelfResponse(
            Long userId,
            boolean isFavorite,
            boolean hasRead,
            LocalDate readDate,
            String bookId,
            String title,
            Object[] author,
            String smallPicture,
            String largePicture,
            Integer releaseYear,
            Object[] issn,
            String publisher,
            Integer pages
    ) {
        this.userId = userId;
        this.isFavorite = isFavorite;
        this.hasRead = hasRead;
        this.readDate = readDate;
        this.book = new Book(
                bookId,
                title,
                author,
                smallPicture,
                largePicture,
                releaseYear,
                issn,
                publisher,
                pages
        );
    }
}
