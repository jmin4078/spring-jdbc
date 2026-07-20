package org.example.springjdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.dto.AccountFormDTO;
import org.example.springjdbc.dto.AccountUpdateDTO;
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
//    public void changeAccount(AccountFormDTO dto) {
    public void changeAccount(AccountUpdateDTO dto) {
        System.out.println("BankServiceImpl.changeAccount");
        System.out.println("dto = " + dto);
        // 기존 엔터티(DB)를 불러와야함
        Account account = accountRepository.findById(dto.id());
        account.setName(dto.name()); // 실질적으로 변경하는 name을 변경해서
        accountRepository.update(account);
    }

    @Override
    public AccountViewDTO findAccount(long id) {
        return AccountViewDTO.fromEntity(accountRepository.findById(id));
    }

    @Override
    public void deleteAccount(long id) {

    }

    @Override
    public List<AccountViewDTO> getAccounts() {
        return accountRepository.findAll() // Account -> AccountViewDTO
                .stream()
                .map(AccountViewDTO::fromEntity)
                .toList();
    }
}