package org.example.springjdbc.repository;

import org.example.springjdbc.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryAccountRepository implements AccountRepository {
    ConcurrentHashMap<Long, Account> store = new ConcurrentHashMap<>();

    @Override
    public void save(Account account) {
        long newId = store.size() + 1;
        account.setId(newId);
        store.put(newId, account);
        System.out.println("store ="+store);
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public List<Account> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public Account findById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}