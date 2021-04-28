package com.example.demo.repos;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankRepo extends JpaRepository<Bank, Long> {
    List<Card> findByName(String name);
    List<Card> findByAddress(String address);
    List<Card> findById(int id);
}
