package com.kaushik.librarymanagement.repository;

import com.kaushik.librarymanagement.entity.BorrowItem;
import com.kaushik.librarymanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowItemRepository extends JpaRepository<BorrowItem, Long> {
    List<BorrowItem> findByUser(User user);
}
