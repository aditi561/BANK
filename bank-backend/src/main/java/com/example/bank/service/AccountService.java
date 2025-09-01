package com.example.bank.service;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }
    public List<Account> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<Account> getAllAccounts() {
        return repo.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return repo.findById(id);
    }

    public Account createAccount(Account account) {
        return repo.save(account);
    }

    public Account updateAccount(Long id, Account account) {
        account.setId(id);
        return repo.save(account);
    }

    public void deleteAccount(Long id) {
        repo.deleteById(id);
    }
}
