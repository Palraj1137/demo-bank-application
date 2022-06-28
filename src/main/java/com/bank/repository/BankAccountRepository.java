package com.bank.repository;

import com.bank.models.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository to declare the own methods for bank accounts
@Repository
public interface BankAccountRepository {
    List<BankAccount> getAllAccounts();
    BankAccount getAccountByAccountId(int accountId);
    void createAccount(BankAccount bankAccount);
    List<BankAccount> getAllAccountsByUserId(int userId);
    List<BankAccount> getAccountsByService(String service);
}
