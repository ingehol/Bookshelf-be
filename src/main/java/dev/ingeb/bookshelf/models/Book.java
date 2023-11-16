package dev.ingeb.bookshelf.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String bookId;
    private String title;
    private Object[] author;
    private String smallPicture;
    private String largePicture;
    private Integer releaseYear;
    private Object[] issn;
    private String publisher;
    private Integer pages;

    public Book() {
    }

    public Book(
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
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.smallPicture = smallPicture;
        this.largePicture = largePicture;
        this.releaseYear = releaseYear;
        this.issn = issn;
        this.publisher = publisher;
        this.pages = pages;
    }
}
