package com.example.repos;

import com.example.components.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepo extends JpaRepository<Card, Long> {
    List<Card> findByOrderByCardNumber();
    List<Card> findByOrderByCode();
    List<Card> findByOrderById();
    List<Card> findByOrderByBankId();
    Card findByCardNumber(int cardNumber);
}
