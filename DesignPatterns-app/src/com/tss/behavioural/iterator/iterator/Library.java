package com.tss.behavioural.iterator.iterator;

import com.tss.behavioural.iterator.model.Book;
import com.tss.behavioural.iterator.model.LibraryCollection;
import com.tss.behavioural.iterator.model.MyIterator;

public class Library implements LibraryCollection {

    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    @Override
    public MyIterator createIterator() {
        return new LibraryIterator(this);
    }
}
