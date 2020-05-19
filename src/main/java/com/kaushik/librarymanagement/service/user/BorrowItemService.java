package com.kaushik.librarymanagement.service.user;

import com.kaushik.librarymanagement.entity.BorrowItem;
import com.kaushik.librarymanagement.entity.User;
import com.kaushik.librarymanagement.repository.BorrowItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowItemService {
    @Autowired
    private BorrowItemRepository borrowItemRepository;

    public Iterable<BorrowItem> getUserItem(User user){
        return borrowItemRepository.findByUser(user);
    }
}
