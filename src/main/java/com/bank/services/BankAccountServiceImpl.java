package com.bank.services;

import com.bank.models.BankAccount;
import com.bank.models.BankingServices;
import com.bank.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//Service to implement the own methods from bank account repository
@Service
public class BankAccountServiceImpl implements BankAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BankAccount> getAllAccounts() {
        String jpql = "SELECT a FROM BankAccount a";
        TypedQuery<BankAccount> query = entityManager.createQuery(jpql, BankAccount.class);
        return query.getResultList();
    }

    @Override
    public BankAccount getAccountByAccountId(int accountId) {
        String jpql = "SELECT a FROM BankAccount a WHERE a.accountId=:id";
        TypedQuery<BankAccount> query = entityManager.createQuery(jpql, BankAccount.class);
        query.setParameter("id", accountId);
        return query.getSingleResult();
    }


    @Transactional
    @Override
    public void createAccount(BankAccount bankAccount) {
        entityManager.persist(bankAccount);
    }

    @Override
    public List<BankAccount> getAllAccountsByUserId(int userId) {
        String jpql = "SELECT a FROM BankAccount a WHERE a.user.userId=:id";
        TypedQuery<BankAccount> query = entityManager.createQuery(jpql, BankAccount.class);
        query.setParameter("id", userId);
        return query.getResultList();
    }

    @Override
    public List<BankAccount> getAccountsByService(String service) {
        Query query = entityManager.createQuery("SELECT a FROM BankAccount a WHERE a.accountId IN (SELECT b.bankAccount.accountId FROM BankingService b where b.bankingServices=:service)", BankAccount.class);
        query.setParameter("service", BankingServices.valueOf(service));
        return query.getResultList();
    }

}
