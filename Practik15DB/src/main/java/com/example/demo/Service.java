package com.example.demo;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import com.example.demo.repos.BankRepo;
import com.example.demo.repos.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Service implements ServiceInterface{
    BankRepo bankRepo;
    CardRepo cardRepo;

    @Autowired
    public Service (BankRepo bankRepo, CardRepo cardRepo){
        this.bankRepo = bankRepo;
        this.cardRepo = cardRepo;
    }

    @Override
    public void addBank(Bank bank) {
        bankRepo.save(bank);
    }

    @Override
    public void addCard(Card card) {
        cardRepo.save(card);
    }

    @Override
    public List<Bank> getAllBanks() {
        List<Bank> bankList = bankRepo.findAll();
        return bankList;
    }

    @Override
    public List<Card> getAllCards() {
        List<Card> cardList = cardRepo.findAll();
        return cardList;
    }

    @Override
    public Bank getBankById(Long id) {
        return bankRepo.getOne(id);
    }

    @Override
    public Card getCardById(Long id) {
        return cardRepo.getOne(id);
    }

    @Override
    public void deleteBankById(Long id) {
        bankRepo.deleteById(id);
    }

    @Override
    public void deleteAllBanks() {
        bankRepo.deleteAll();
    }

    @Override
    public void deleteCardById(Long id) {
        cardRepo.deleteById(id);
    }

    @Override
    public void deleteAllCards() {
        cardRepo.deleteAll();
    }
}
