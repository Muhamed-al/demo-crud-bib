package com.tekup.sdia_en.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;

    @ManyToMany
    @JoinTable(
            name="book_categories",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private List<Category> categories;

}
