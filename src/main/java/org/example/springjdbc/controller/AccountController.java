package org.example.springjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.dto.AccountViewDTO;
import org.example.springjdbc.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final BankService bankService;

    // /account/{id} - (/account)
    @RequestMapping("/{id}") // PathVariable
    public String getAccountById(@PathVariable long id, Model model) {
        AccountViewDTO account = bankService.findAccount(id);
        model.addAttribute("account", account);
        return "account"; // views/account.jsp
    }
}