package com.kaushik.librarymanagement.service;

import com.kaushik.librarymanagement.entity.Book;
import com.kaushik.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    public Iterable<Book> getAllData(){
        return bookRepository.findAll();
    }

    public Optional<Book> getData(Long id){
        return bookRepository.findById(id);
    }

    public void saveOrUpdate(Book book){
        bookRepository.save(book);
    }

    public String deleteData(Long id){
        bookRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
