package com.example.demo.service;

import com.example.demo.components.Bank;
import com.example.demo.repos.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class bankService implements bankServiceInterface{
    BankRepo bankRepo;

    @Autowired
    public bankService(BankRepo bankRepo){
        this.bankRepo = bankRepo;
    }

    @Override
    public void addBank(Bank bank) {
        bankRepo.save(bank);
    }

    @Override
    public List<Bank> getAllBanks() {
        List<Bank> bankList = bankRepo.findAll();
        return bankList;
    }

    @Override
    public List<Bank> filterByName() {
        return bankRepo.findByOrderByName();
    }

    @Override
    public List<Bank> filterByAddress() {
        return bankRepo.findByOrderByAddress();
    }

    @Override
    public List<Bank> filterByBankId() {
        return bankRepo.findByOrderById();
    }

    @Override
    public Bank getBankById(Long id) {
        return bankRepo.getOne(id);
    }

    @Override
    public void deleteBankById(Long id) {
        try {
            bankRepo.deleteById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Bank has linked cards! You cant remove it!");
        }
    }

    @Override
    public void deleteAllBanks() {
        bankRepo.deleteAll();
    }

    @Override
    public Long getBankId(String name) {
        return bankRepo.findByName(name).getId();
    }
}
