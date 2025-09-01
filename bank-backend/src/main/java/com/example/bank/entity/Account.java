package com.example.bank.entity;

import jakarta.persistence.*;

/**
 * Entity class representing a bank account.
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)  // ensures name cannot be null
    private String name;

    @Column(nullable = false)  // ensures balance cannot be null
    private Double balance;

    // Default constructor required by JPA
    public Account() {}

    // Convenience constructor
    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Getters & Setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public Double getBalance() { 
        return balance; 
    }

    public void setBalance(Double balance) { 
        this.balance = balance; 
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
