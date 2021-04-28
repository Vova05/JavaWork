package com.example.demo;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CardController {
    @Autowired
    private Work work;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/home/show")
    public @ResponseBody String show(){
        String buff = "<h>Banks</h><table border=1>";
        int i = 0;
        for (Bank item: work.getBanks()) {
            buff += "<tr><td>" + item.getName() + "</td><td>" + item.getAddress() + "</td><td><a href='removeBank?id=" + item.getId() + "'>Delete</a></td></tr>";
            i++;
        }
        if (i == 0)
        {
            buff+= "<tr><td>Bank list is empty</td></tr>";
        }
        i = 0;
        buff += "</table>";
        buff += "<h>Cards</h><table border=1>";
        for (Card item: work.getCards()) {
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

    @PostMapping("/home/addBank")
    public String add(@RequestParam String name,
                      @RequestParam String address){
        Bank bank = new Bank();
        bank.setName(name);
        bank.setAddress(address);
        work.saveBank(bank);
        return "home";
    }
    @PostMapping("/home/addCard")
    public String add(@RequestParam int cardNumber,
                      @RequestParam int code, String name){
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setCode(code);
        card.bank = work.getBankById(work.getBankId(name));
        work.saveCard(card);
        return "home";
    }
    @GetMapping("/home/removeCard")
    public @ResponseBody String removeCards(@RequestParam Long id){
        work.removeCard(id);
        return show();
    }
    @GetMapping("/home/removeBank")
    public @ResponseBody String removeBanks(@RequestParam Long id){
        work.removeBank(id);
        return show();
    }
    @GetMapping("/home/getCardBank")
    public @ResponseBody String getCardBank(@RequestParam Long id){
        return "name:" + work.getBankByCard(id).getName() + " address:" + work.getBankByCard(id).getAddress() + " id:" + work.getBankByCard(id).getId();
    }

}
