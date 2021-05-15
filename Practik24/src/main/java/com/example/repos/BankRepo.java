package com.example.repos;

import com.example.components.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankRepo extends JpaRepository<Bank, Long> {
    List<Bank> findByOrderByName();
    List<Bank> findByOrderByAddress();
    List<Bank> findByOrderById();
    Bank findByName(String name);

    List<Bank> findAll();
}
