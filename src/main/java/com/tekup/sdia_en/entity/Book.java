package com.tekup.sdia_en.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Min(value = 1 , message = "Stock lust be greater than 1")
    private int  stock;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;

    @ManyToMany
    @JoinTable(
            name="book_categories",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    @JsonIgnoreProperties("books")
    private List<Category> categories;

}
