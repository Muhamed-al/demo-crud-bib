package com.tekup.sdia_en.repository;

import com.tekup.sdia_en.entity.Book;
import com.tekup.sdia_en.entity.Borrow;
import com.tekup.sdia_en.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow , Long> {

    List<Borrow> findByUser(User user);

    List<Borrow> findByBook(Book book);

    List<Borrow> findByReturnDateBefore(LocalDate date);
}
