package com.example.demo;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public void addBank(Bank bank) {
        Session session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(bank);
        transaction.commit();
        session.close();
    }

    @Override
    public void addCard(Card card) {
        Session session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(card);
        transaction.commit();
        session.close();
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Bank> getAllBanks() {
        Session session = sessionFactory.openSession();
        List<Bank> banks = session.createQuery("select b from Bank b", Bank.class).getResultList();
        session.close();
        return banks;
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Card> getAllCards() {
        Session session = sessionFactory.openSession();
        List<Card> cards = session.createQuery("select c from Card c", Card.class).getResultList();
        session.close();
        return cards;
    }

    @Override
    @JsonIgnore
    public Bank getBankById(Long id) {
        Bank buff = new Bank();
        List<Bank> banks = getAllBanks();
        for (Bank item:banks) {
            if(id == item.getId()){
                buff = item;
            }
        }
        return  buff;
    }

    @Override
    @JsonIgnore
    public Card getCardById(Long id) {
        List<Card> cards = getAllCards();
        Card buff = new Card();
        for (Card item:cards) {
            if(id == item.getId()){
                buff = item;
            }
        }
        return buff;
    }

    @Override
    public void deleteBankById(Long id) {
        Bank buff = new Bank();
        List<Bank> banks = getAllBanks();
        for (Bank item:banks) {
            if(id == item.getId()){
                buff = item;
            }
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Bank.class, buff.getId()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAllBanks() {

    }

    @Override
    public void deleteCardById(Long id) {
        List<Card> cards = getAllCards();
        Card buff = new Card();
        for (Card item:cards) {
            if(id == item.getId()){
                buff = item;
            }
        }
        System.out.println(buff.getCardNumber());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Card.class, buff.getId()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAllCards() {

    }

    @Override
    public Bank getBanByCard(Long card_id) {
        Bank buff;
        Session session = sessionFactory.openSession();
        buff = session.createQuery("select c from Card c where c.id = :id", Card.class)
                .setParameter("id",card_id).getSingleResult().getBank();
        return buff;
    }

    @Override
    public Long getBankId(String name) {
        List<Bank> banks = getAllBanks();
        Long buff = new Long(0);
        for (Bank item:banks) {
            if(name.equals(item.getName())){
                buff = item.getId();
            }
        }
        return buff;
    }

    @Override
    public Long getCardId(int cardNumber) {
        List<Card> cards = getAllCards();
        Long buff = new Long(0);
        for (Card item:cards) {
            if(cardNumber == item.getCardNumber()){
                buff = item.getId();
            }
        }
        return buff;
    }
}
