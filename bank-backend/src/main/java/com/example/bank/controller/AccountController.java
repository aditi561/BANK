package com.example.bank.controller;

import com.example.bank.entity.Account;
import com.example.bank.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // ✅ Get all accounts
    @GetMapping
    public List<Account> getAll() {
        return service.getAllAccounts();
    }
    
 // Search by name
    @GetMapping("/search")
    public List<Account> searchAccounts(@RequestParam String name) {
        return service.searchByName(name);
    }

    // ✅ Get account by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id) {
        return service.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Create new account
    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        Account created = service.createAccount(account);
        return ResponseEntity.ok(created);
    }

    // ✅ Update account
    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account account) {
        return service.getAccountById(id)
                .map(existing -> ResponseEntity.ok(service.updateAccount(id, account)))
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Delete account
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.getAccountById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
