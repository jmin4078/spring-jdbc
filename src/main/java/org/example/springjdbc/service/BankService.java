package org.example.springjdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.dto.AccountFormDTO;
import org.example.springjdbc.dto.AccountViewDTO;
import org.example.springjdbc.entity.Account;
import org.example.springjdbc.repository.AccountRepository;
import org.springframework.stereotype.Service;


public interface BankService {
    void makeAccount(AccountFormDTO dto);
    void changeAccount(AccountFormDTO dto);
    AccountViewDTO findAccount(long id);
    void deleteAccount(long id);
}
