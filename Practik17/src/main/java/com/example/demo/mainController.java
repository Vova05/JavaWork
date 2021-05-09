package com.example.demo;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class mainController {
    @Autowired
    private Service service;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/home/show")
    public @ResponseBody String show(){
        String buff ="";
        buff += service.printBanks(service.getAllBanks());
        buff += service.printCards(service.getAllCards());
        return buff;
    }

    @PostMapping("/home/addBank")
    public String add(@RequestParam String name,
                      @RequestParam String address){
        Bank bank = new Bank();
        bank.setName(name);
        bank.setAddress(address);
        service.addBank(bank);
        return "home";
    }
    @PostMapping("/home/addCard")
    public String add(@RequestParam int cardNumber,
                      @RequestParam int code, String name){
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setCode(code);
        card.bank = service.getBankById(service.getBankId(name));
        service.addCard(card);
        return "home";
    }
    @GetMapping("/home/removeCard")
    public @ResponseBody String removeCards(@RequestParam Long id){
        service.deleteCardById(id);
        return show();
    }
    @GetMapping("/home/removeBank")
    public @ResponseBody String removeBanks(@RequestParam Long id){
        service.deleteBankById(id);
        return show();
    }
    @GetMapping("/home/getCardBank")
    public @ResponseBody String getCardBank(@RequestParam Long id){
        return "name:" + service.getBankByCard(id).getName() + " address:" + service.getBankByCard(id).getAddress() + " id:" + service.getBankByCard(id).getId();
    }

    @GetMapping("/home/getBankByName")
    public @ResponseBody
    String getBanksByName(){
        return service.printBanks(service.filterByName());
    }
    @GetMapping("/home/getBankById")
    public @ResponseBody
    String getBanksById(){
        return service.printBanks(service.filterByBankId());
    }
    @GetMapping("/home/getBankByAddress")
    public @ResponseBody
    String getBanksByAddress(){
        return service.printBanks(service.filterByAddress());
    }
    @GetMapping("/home/getCardById")
    public @ResponseBody
    String getCardsById(){
        return service.printCards(service.filterByCardId());
    }
    @GetMapping("/home/getCardByCode")
    public @ResponseBody
    String getCardsByCode(){
        return service.printCards(service.filterByCode());
    }
    @GetMapping("/home/getCardByCardNumber")
    public @ResponseBody
    String getCardsByCardNumber(){
        return service.printCards(service.filterByCardNumber());
    }

}
