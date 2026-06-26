package com.tss.behavioural.iterator.iterator;

import com.tss.behavioural.iterator.model.Book;
import com.tss.behavioural.iterator.model.MyIterator;

public class LibraryIterator implements MyIterator {

    private Library library;
    private int index;

    public LibraryIterator(Library library) {
        this.library = library;
    }

    @Override
    public boolean hasNext() {
        return index < library.getBooks().length;
    }

    @Override
    public Book next() {
        return library.getBooks()[index++];
    }
}
