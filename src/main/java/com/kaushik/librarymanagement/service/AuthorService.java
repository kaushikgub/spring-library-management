package com.kaushik.librarymanagement.service;

import com.kaushik.librarymanagement.entity.Author;
import com.kaushik.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> getAllData(){
        return authorRepository.findAll();
    }

    public Optional<Author> getData(Long id){
        return authorRepository.findById(id);
    }

    public void saveOrUpdate(Author author){
        authorRepository.save(author);
    }

    public void deleteData(Long id){
        authorRepository.deleteById(id);
    }
}
