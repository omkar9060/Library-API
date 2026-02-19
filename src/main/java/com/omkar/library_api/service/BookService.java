package com.omkar.library_api.service;

import com.omkar.library_api.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private Map<Long, Book> books = new HashMap<>();
    private Long idCounter = 1L;

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book addBook(Book book) {
        book.setId(idCounter++);
        books.put(book.getId(), book);
        return book;
    }

    public void deleteBook(Long id) {
        books.remove(id);
    }
}
