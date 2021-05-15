package com.example.demo.service;

import com.example.demo.components.Bank;
import com.example.demo.repos.BankRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Component
public class bankService implements bankServiceInterface{
    BankRepo bankRepo;

    @Autowired
    public bankService(BankRepo bankRepo){
        this.bankRepo = bankRepo;
    }

    @Override
    public void addBank(Bank bank) {
        log.info("Added new bank {}", bank);
        bankRepo.save(bank);
    }

    @Override
    public List<Bank> getAllBanks() {
        log.info("Found all banks");
        List<Bank> bankList = bankRepo.findAll();
        return bankList;
    }

    @Override
    public List<Bank> filterByName() {
        log.info("Sorted list of banks by name");
        return bankRepo.findByOrderByName();
    }

    @Override
    public List<Bank> filterByAddress() {
        log.info("Sorted list of banks by address");
        return bankRepo.findByOrderByAddress();
    }

    @Override
    public List<Bank> filterByBankId() {
        log.info("Sorted list of banks by id");
        return bankRepo.findByOrderById();
    }

    @Override
    public Bank getBankById(Long id) {
        log.info("Found bank by id {}", id);
        return bankRepo.getOne(id);
    }

    @Override
    public void deleteBankById(Long id) {
        log.warn("Trying to delete bank with id {}", id);
        try {
            log.info("Deleted bank with id {} successfully", id);
            bankRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Failed to delete bank with id", id);
            throw new IllegalStateException("Bank has linked cards! You cant remove it!");
        }
    }

    @Override
    public void deleteAllBanks() {
        log.info("Deleted all banks");
        bankRepo.deleteAll();
    }

    @Override
    public Long getBankId(String name) {
        log.info("Found bank id with name {}", name);
        return bankRepo.findByName(name).getId();
    }
}
