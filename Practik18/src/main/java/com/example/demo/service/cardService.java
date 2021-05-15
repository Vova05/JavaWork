package com.example.demo.service;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import com.example.demo.repos.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class cardService implements cardServiceInterface{
    CardRepo cardRepo;

    @Autowired
    public cardService(CardRepo cardRepo){
        this.cardRepo = cardRepo;
    }

    @Override
    public void addCard(Card card) {
        cardRepo.save(card);
    }

    @Override
    public List<Card> getAllCards() {
        List<Card> cardList = cardRepo.findAll();
        return cardList;
    }

    @Override
    public List<Card> filterByCardNumber() {
        return cardRepo.findByOrderByCardNumber();
    }

    @Override
    public List<Card> filterByCode() {
        return cardRepo.findByOrderByCode();
    }

    @Override
    public List<Card> filterByCardId() {
        return cardRepo.findByOrderById();
    }

    @Override
    public List<Card> filterByRelatedBankId() {
        return cardRepo.findByOrderByBankId();
    }

    @Override
    public Card getCardById(Long id) {
        return cardRepo.getOne(id);
    }

    @Override
    public void deleteCardById(Long id) {
        cardRepo.deleteById(id);
    }

    @Override
    public void deleteAllCards() {
        cardRepo.deleteAll();
    }

    @Override
    public Bank getBankByCard(Long id) {
        return cardRepo.findById(id).orElseThrow(() ->
                new IllegalStateException("Card with this id not found")).getBank();
    }

    @Override
    public Long getCardId(int cardNumber) {
        return cardRepo.findByCardNumber(cardNumber).getId();
    }
}
