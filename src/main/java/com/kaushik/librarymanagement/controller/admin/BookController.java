package com.kaushik.librarymanagement.controller.admin;

import com.kaushik.librarymanagement.entity.Book;
import com.kaushik.librarymanagement.service.AuthorService;
import com.kaushik.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/admin/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("books", bookService.getAllData());
        model.addAttribute("authors", authorService.getAllData());
        return "admin/book";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@Valid Book book){
        book.setCreatedAt(new Date());
        book.setDescription(book.getDescription().isEmpty() ? "---" : book.getDescription());
        bookService.saveOrUpdate(book);
        return "Saved Successfully";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        return bookService.deleteData(id);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<Book> getData(@PathVariable Long id){
        return bookService.getData(id);
    }
}
