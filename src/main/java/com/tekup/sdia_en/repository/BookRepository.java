package com.tekup.sdia_en.repository;

import com.tekup.sdia_en.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Long> {

}
