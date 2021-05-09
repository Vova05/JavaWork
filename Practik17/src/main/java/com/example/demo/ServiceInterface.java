package com.example.demo;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;

import java.util.List;

public interface ServiceInterface {
    void addBank(Bank bank);
    void addCard(Card card);
    List<Bank> getAllBanks();
    List<Card> getAllCards();
    List<Bank> filterByName();
    List<Bank> filterByAddress();
    List<Bank> filterByBankId();
    List<Card> filterByCardNumber();
    List<Card> filterByCode();
    List<Card> filterByCardId();
    List<Card> filterByRelatedBankId();
    Bank getBankById(Long id);
    Card getCardById(Long id);
    void deleteBankById(Long id);
    void deleteAllBanks();
    void deleteCardById(Long id);
    void deleteAllCards();
    Bank getBankByCard(Long id);
    Long getBankId(String name);
    Long getCardId(int cardNumber);
}
