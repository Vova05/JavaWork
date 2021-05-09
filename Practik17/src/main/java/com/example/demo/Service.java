package com.example.demo;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface {
    @Autowired
    private SessionFactory sessionFactory;

    //adding new bank
    @Override
    public void addBank(Bank bank) {
        Session session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(bank);
        transaction.commit();
        session.close();
    }

    //adding new card
    @Override
    public void addCard(Card card) {
        Session session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(card);
        transaction.commit();
        session.close();
    }

    //getting list of banks
    @PostConstruct
    @Override
    @JsonIgnore
    public List<Bank> getAllBanks() {
        Session session = sessionFactory.openSession();
        List<Bank> banks = session.createQuery("select b from Bank b", Bank.class).getResultList();
        session.close();
        return banks;
    }

    //getting list of cards
    @PostConstruct
    @Override
    @JsonIgnore
    public List<Card> getAllCards() {
        Session session = sessionFactory.openSession();
        List<Card> cards = session.createQuery("select c from Card c", Card.class).getResultList();
        session.close();
        return cards;
    }

    //filtering list of banks by name
    @PostConstruct
    @Override
    @JsonIgnore
    public List<Bank> filterByName() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bank> bankCriteriaQuery = builder.createQuery(Bank.class);
        Root<Bank> root = bankCriteriaQuery.from(Bank.class);
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Bank> query = session.createQuery(bankCriteriaQuery);
        List<Bank> banks = query.getResultList();
        session.close();
        return banks;
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Bank> filterByAddress() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bank> bankCriteriaQuery = builder.createQuery(Bank.class);
        Root<Bank> root = bankCriteriaQuery.from(Bank.class);
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("address")));
        Query<Bank> query = session.createQuery(bankCriteriaQuery);
        List<Bank> banks = query.getResultList();
        session.close();
        return banks;
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Bank> filterByBankId() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bank> bankCriteriaQuery = builder.createQuery(Bank.class);
        Root<Bank> root = bankCriteriaQuery.from(Bank.class);
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("id")));
        Query<Bank> query = session.createQuery(bankCriteriaQuery);
        List<Bank> banks = query.getResultList();
        session.close();
        return banks;
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Card> filterByCardNumber() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Card> bankCriteriaQuery = builder.createQuery(Card.class);
        Root<Card> root = bankCriteriaQuery.from(Card.class);
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("cardNumber")));
        Query<Card> query = session.createQuery(bankCriteriaQuery);
        List<Card> cards = query.getResultList();
        session.close();
        return cards;
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Card> filterByCode() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Card> bankCriteriaQuery = builder.createQuery(Card.class);
        Root<Card> root = bankCriteriaQuery.from(Card.class);
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("code")));
        Query<Card> query = session.createQuery(bankCriteriaQuery);
        List<Card> cards = query.getResultList();
        session.close();
        return cards;
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Card> filterByCardId() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Card> bankCriteriaQuery = builder.createQuery(Card.class);
        Root<Card> root = bankCriteriaQuery.from(Card.class);
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("id")));
        Query<Card> query = session.createQuery(bankCriteriaQuery);
        List<Card> cards = query.getResultList();
        session.close();
        return cards;
    }

    @PostConstruct
    @Override
    @JsonIgnore
    public List<Card> filterByRelatedBankId() {
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Card> bankCriteriaQuery = builder.createQuery(Card.class);
//        Root<Card> root = bankCriteriaQuery.from(Card.class);
//        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("bank_id")));
//        Query<Card> query = session.createQuery(bankCriteriaQuery);
//        List<Card> cards = query.getResultList();
//        session.close();
//        return cards;\
        return null;
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
    public Bank getBankByCard(Long card_id) {
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
    public String printBanks(List<Bank> list){
        String buff = "<h>Banks</h><table border=1>";
        int i = 0;
        for (Bank item: list) {
            buff += "<tr><td>" + item.getName() + "</td><td>" + item.getAddress() + "</td><td><a href='removeBank?id=" + item.getId() + "'>Delete</a></td></tr>";
            i++;
        }
        if (i == 0)
        {
            buff+= "<tr><td>Bank list is empty</td></tr>";
        }
        i = 0;
        buff += "</table>";
        return buff;
    }
    public String printCards(List<Card> list){
        String buff ="";
        int i = 0;
        buff += "<h>Cards</h><table border=1>";
        for (Card item: list) {
            buff += "<tr><td>" + item.getCode() + "</td><td>" + item.getCardNumber() + "</td><td><a href='removeCard?id=" + item.getId() + "'>Delete</a></td></tr>";
            i++;
        }
        if (i == 0)
        {
            buff+= "<tr><td>Card list is empty</td></tr>";
        }
        buff += "</table>";
        return buff;
    }
}
