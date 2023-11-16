package dev.ingeb.bookshelf.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Bookshelf {
    private Long userId;
    private String bookId;
    private boolean isFavorite;
    private boolean hasRead;
    private LocalDate readDate;
}
