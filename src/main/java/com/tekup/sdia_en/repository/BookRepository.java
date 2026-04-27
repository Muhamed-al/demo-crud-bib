package com.tekup.sdia_en.repository;

import com.tekup.sdia_en.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book , Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByStockGreaterThan(int stock);

    // Using JPQL
   @Query("Select b from Book b JOIN b.categories c where c.name = :name" )
    List<Book> findByCategoryName(@Param("name") String name);

    // Using Keywords
    //List<Book> findByCategoriesName(String name);
}
