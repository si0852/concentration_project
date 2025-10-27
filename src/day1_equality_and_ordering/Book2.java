package day1_equality_and_ordering;

import java.util.Objects;

public class Book2 {

    private int bookId;
    private String title;
    private String author;
    private String publisher;

    public Book2(int bookId, String title, String author, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public int hashCode() {
        int id = 11;
        id = 10 * id + Objects.hash(bookId, title, author);
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Book2 book = (Book2) obj;
        return bookId == book.bookId && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
}
