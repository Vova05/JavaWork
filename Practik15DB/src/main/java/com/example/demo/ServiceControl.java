package com.example.demo;

import com.example.demo.components.Bank;
import com.example.demo.components.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller

//@RequestMapping("/home")
public class ServiceControl {
    @Autowired
    private Service service;

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @GetMapping("/home/show")
    public @ResponseBody String show(){
        String buff = "<h>Banks</h><table border=1>";
        int i = 0;
        for (Bank item: service.getAllBanks()) {
            buff += "<tr><td>" + item.getName() + "</td><td>" + item.getAddress() + "</td><td><a href='/home/removeBank?id=" + item.getId() + "'>Delete</a></td></tr>";
            i++;
        }
        if (i == 0)
        {
            buff+= "<tr><td>Bank list is empty</td></tr>";
        }
        i = 0;
        buff += "</table>";
        buff += "<h>Cards</h><table border=1>";
        for (Card item: service.getAllCards()) {
            buff += "<tr><td>" + item.getCode() + "</td><td>" + item.getCardNumber() + "</td><td><a href='/home/removeCard?id=" + item.getId() + "'>Delete</a></td></tr>";
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
    public ModelAndView addBank(@RequestParam String name,
                      @RequestParam String address){
        Bank bank = new Bank();
        bank.setName(name);
        bank.setAddress(address);
        service.addBank(bank);
        return new ModelAndView("/home");
    }
    @PostMapping("/home/addCard")
    public ModelAndView addCard(@RequestParam int cardNumber,
                      @RequestParam int code){
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setCode(code);
        service.addCard(card);
        return new ModelAndView("/home");
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

}
