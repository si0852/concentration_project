package day1_equality_and_ordering;

import java.util.Objects;

public class Book {

    private int bookId;
    private String title;
    private String author;


    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

//    @Override
//    public int hashCode() {
//        int id = 11;
//        id = 10 * id + Objects.hash(bookId, title, author);
//        return id;
//    }
//
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return bookId == book.bookId && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
}
