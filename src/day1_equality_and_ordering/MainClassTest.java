package day1_equality_and_ordering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainClassTest {

    private Book book;
    private Book book2;
    private Book book3;
    private Book2 book4;
    private Book2 book5;
    private Book2 book6;


    @Test
    void equals_is_reflexive() {
        //given
        book = new Book(1, "phone", "apple");
        //when
        boolean equals = book.equals(book);
        //then
        Assertions.assertEquals(equals, true);
    }

    @Test
    void equals_is_symmetric() {
        //given
        book = new Book(1, "phone", "apple");
        book2 = new Book(1, "phone", "apple");
        //when
        boolean equals = book.equals(book2);
        boolean equals1 = book2.equals(book);
        //then
        Assertions.assertEquals(equals1, equals);
    }

    @Test
    void equals_is_transitive() {
        //given
        book = new Book(1, "phone", "apple");
        book2 = new Book(1, "phone", "apple");
        book3 = new Book(1, "phone", "apple");
        //when
        boolean equals = book.equals(book2);
        boolean equals1 = book2.equals(book3);
        boolean equals2 = book.equals(book3);
        //then
        Assertions.assertEquals(equals, true); // a=b
        Assertions.assertEquals(equals1, true); // b=c
        Assertions.assertEquals(equals2, true); // a=c
    }

    @Test
    @DisplayName("동일 상태에서 여러번 비교해도 결과 동일")
    void equals_is_consistent() {
        //given
        book = new Book(1, "phone", "apple");
        book2 = new Book(1, "phone", "apple");
        // when
        boolean result = true;
        for (int i = 0; i < 100; i++) {
            boolean equals = book.equals(book2);
            if (!equals) {
                result = false;
            }
        }

        //then
        Assertions.assertEquals(result, true);
    }

    @Test
    void equals_handles_null() {
        //given
        book = new Book(1, "phone", "apple");
        //when
        boolean equals = book.equals(null);
        //then
        Assertions.assertEquals(equals, false);
    }

    @Test
    void equals_handles_defferent_class() {
        //given
        book = new Book(1, "phone", "apple");
        //when
        boolean equals = book.equals(new Book2(1, "phone", "apple", "bobobo"));
        //then
        Assertions.assertEquals(equals, false);
    }

    @Test
    void equals_respects_field_selection() {
        //given
        book4 = new Book2(1, "phone", "apple", "bobobo");
        book5 = new Book2(1, "phone", "apple", "bobobo");
        book6 = new Book2(1, "phone", "samsung", "bobobo");
        //when
        boolean equals = book4.equals(book5);
        boolean equals2 = book4.equals(book6);

        //then
        Assertions.assertEquals(equals, true);
        Assertions.assertEquals(book4.hashCode(), book5.hashCode());
        Assertions.assertEquals(equals2, false);
        Assertions.assertNotEquals(book4.hashCode(), book6.hashCode());
    }
}