package com.sqlInjection.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Customer {
    String username;
    String password;
    @Id
    String accountNumber;
    double balance;

    public Customer(String username, String password, String accountNumber, double balance) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
