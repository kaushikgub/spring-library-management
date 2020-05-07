package com.kaushik.librarymanagement.controller.admin;

import com.kaushik.librarymanagement.entity.Author;
import com.kaushik.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/admin/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("authors", authorService.getAllData());
        return "admin/author";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@Valid Author author){
        author.setCreatedAt(new Date());
        author.setDescription(author.getDescription().isEmpty() ? "---" : author.getDescription());
        authorService.saveOrUpdate(author);
        return "Saved Successfully";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        authorService.deleteData(id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<Author> getData(@PathVariable Long id){
        return authorService.getData(id);
    }
}
