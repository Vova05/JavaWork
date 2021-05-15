package com.example.service.emailService;

import com.example.components.Bank;
import com.example.components.Card;

public interface emailServiceInterface {

    void sendMessageAboutBank(Bank bank);

    void sendMessageAboutCard(Card card);
}
