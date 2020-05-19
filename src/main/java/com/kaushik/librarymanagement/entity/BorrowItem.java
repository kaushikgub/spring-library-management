package com.kaushik.librarymanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class BorrowItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @NotBlank
    private Date dueDate;
    private Integer fine;
    private String narrative;
    @NotBlank
    private Date createdAt;

    public BorrowItem() {
    }

    public BorrowItem(Long id, User user, Book book, @NotBlank Date dueDate, Integer fine, String narrative, @NotBlank Date createdAt) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.dueDate = dueDate;
        this.fine = fine;
        this.narrative = narrative;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
