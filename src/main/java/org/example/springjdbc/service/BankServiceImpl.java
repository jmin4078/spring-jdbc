package org.example.springjdbc.service;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.dto.AccountFormDTO;
import org.example.springjdbc.dto.AccountUpdateDTO;
import org.example.springjdbc.dto.AccountViewDTO;
import org.example.springjdbc.entity.Account;
import org.example.springjdbc.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true) // 읽기 전용 트랜잭션
// -> 여러명이 접속한다고 가정했을 때,
// -> 읽기는 괜찮은데, 쓰기를 못하도록 막는 것
// -> accounts에 대해서
public class BankServiceImpl implements BankService {
    private final AccountRepository accountRepository;

    // 클래스 또는 메서드 단위로 트랜잭션
    @Transactional // 쓰기까지 포함
    @Override
    public void makeAccount(AccountFormDTO dto) {
        // START TRANSACTION
        System.out.println("BankServiceImpl.makeAccount");
        System.out.println("dto = " + dto);
        Account newAccount = Account.builder().name(dto.name()).build();
        accountRepository.save(newAccount);
//        throw new RuntimeException("DB에 생성한 다음 예외");
        // COMMIT
        // AOP
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
        accountRepository.deleteById(id);
    }

    @Override
    public List<AccountViewDTO> getAccounts() {
        return accountRepository.findAll() // Account -> AccountViewDTO
                .stream()
                .map(AccountViewDTO::fromEntity)
                .toList();
    }
}