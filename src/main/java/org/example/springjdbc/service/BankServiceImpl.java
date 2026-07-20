package org.example.springjdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.dto.AccountFormDTO;
import org.example.springjdbc.dto.AccountViewDTO;
import org.example.springjdbc.entity.Account;
import org.example.springjdbc.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private final AccountRepository accountRepository;

    @Override
    public void makeAccount(AccountFormDTO dto) {
        System.out.println("BankServiceImpl.makeAccount");
        System.out.println("dto = " + dto);
        Account newAccount = Account.builder().name(dto.name()).build();
        accountRepository.save(newAccount);
    }

    @Override
    public void changeAccount(AccountFormDTO dto) {

    }

    @Override
    public AccountViewDTO findAccount(long id) {
        return null;
    }

    @Override
    public void deleteAccount(long id) {

    }

    @Override
    public List<AccountViewDTO> getAccounts() {
        return List.of();
    }
}