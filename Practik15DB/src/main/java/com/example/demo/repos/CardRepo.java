package com.example.demo.repos;

import com.example.demo.components.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepo extends JpaRepository<Card, Long> {
    List<Card> findByCardNumber(int cardNumber);
    List<Card> findByCode(int code);
    List<Card> findById(int id);
}
