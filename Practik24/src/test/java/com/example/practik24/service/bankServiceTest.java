package com.example.practik24.service;

import com.example.components.Bank;
import com.example.repos.BankRepo;
import com.example.service.bankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class bankServiceTest {
    @Mock
    BankRepo bankRepo;
    @Captor
    ArgumentCaptor<Bank> captor;
    @Test
    void getAll(){
        Bank bank = new Bank();
        bank.setName("Qwerty");
        Bank bank1 = new Bank();
        bank1.setName("Asdfgh");
        Mockito.when(bankRepo.findAll()).thenReturn(List.of(bank,bank1));
        //assertEquals(2, bankRepo.findAll().size());
    }
    @Test
    void create() {
        Bank bank = new Bank();
        bank.setName("devil");
        bankService ss = new bankService(bankRepo);
        ss.addBank(bank);
        Mockito.verify(bankRepo).save(captor.capture());
        Bank captured = captor.getValue();
        //assertEquals("devil", captured.getName());
    }
}