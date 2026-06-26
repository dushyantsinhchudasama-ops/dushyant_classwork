package com.tss.behavioural.iterator.test;

import com.tss.behavioural.iterator.iterator.Library;
import com.tss.behavioural.iterator.model.Book;
import com.tss.behavioural.iterator.model.MyIterator;

public class IteratorTest {

    public static void main(String[] args) {

        Book[] books = {
                new Book("Java"),
                new Book("Spring"),
                new Book("Hibernate"),
                new Book("Design Patterns")
        };

        Library library = new Library(books);

        MyIterator iterator = library.createIterator();

        while(iterator.hasNext()) {

            Book book = iterator.next();

            System.out.println(book.getTitle());
        }
    }
}