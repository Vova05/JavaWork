package com.example.practik14;

import com.example.practik14.components.Bank;
import com.example.practik14.components.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankWork {

    private final List<Bank> banks = new ArrayList<>();
    private final List<Card> cards = new ArrayList<>();

    public void saveBank(Bank bank) {
        if (!(banks.contains(bank))){
            banks.add(bank);
        }
    }
    public void saveCard(Card card) {
        if (!(cards.contains(card))){
            cards.add(card);
        }
    }

    public void removeCards (int id){
        cards.remove(id);
    }

    public void removeBanks (int id){
        banks.remove(id);;
    }

    public List<Bank> getBanks(){
        return banks;
    }

    public List<Card> getCards(){
        return cards;
    }

}
