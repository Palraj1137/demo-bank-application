package com.bank.repository;

import com.bank.models.BankingService;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository to declare the own methods for banking services
@Repository
public interface BankingServiceRepository {
    void saveBankingServices(BankingService bankingService);
    List<BankingService> getAccountsByService(String service);
}
