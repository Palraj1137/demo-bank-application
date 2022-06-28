package com.bank.services;

import com.bank.models.BankingService;
import com.bank.models.BankingServices;
import com.bank.repository.BankingServiceRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//Service to implement the own methods from banking services repository
@Service
public class BankingServiceImpl implements BankingServiceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void saveBankingServices(BankingService bankingService) {
        entityManager.persist(bankingService);
    }

    @Override
    public List<BankingService> getAccountsByService(String service) {
//        BankingServices bankingServices = BankingServices.valueOf(service);
        String jpql = "SELECT b from BankingService b";
        TypedQuery<BankingService> query = entityManager.createQuery(jpql, BankingService.class);
//        query.setParameter("service", bankingServices);
        return query.getResultList();
    }
}
