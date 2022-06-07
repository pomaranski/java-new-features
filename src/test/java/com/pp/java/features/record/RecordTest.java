package com.pp.java.features.record;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecordTest {

    @Test
    public void showRecords() {
        var title = "title";
        var author = "author";
        var book = new Book(title, author);

        assertEquals(title, book.title());
        assertEquals(author, book.author());
    }

    @Test
    public void serialize() {
        serialize(new Book(null, "content"), "book");
        serialize(new BookClass(null, "content"), "bookclass");
    }

    @Test
    public void validation() {
        // TODO add validation to record checking if title is not null
        assertEquals("title", new Book("title", "author").title());
        assertThrows(IllegalArgumentException.class, () -> new Book(null, "author"));
    }

    @Test
    public void deserialize() {
        deserialize("book");
        deserialize("bookclass");
    }

    private void serialize(Object object, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object deserialize(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return objectIn.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

// TODO replace by records
final class Book implements Serializable {

    private final String title;
    private final String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Book[title=%s, author=%s]".formatted(title, author);
    }
}

final class BookClass implements Serializable {

    private final String title;
    private final String author;

    BookClass(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BookClass book = (BookClass) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "BookClass[title=%s, author=%s]".formatted(title, author);
    }
}
