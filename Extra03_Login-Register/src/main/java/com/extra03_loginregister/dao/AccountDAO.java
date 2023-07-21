package com.extra03_loginregister.dao;

import com.extra03_loginregister.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class AccountDAO {
    @Autowired
    EntityManager entityManager;

    public List<Account> getAccounts() {
        String hql = "select a from Account a";
        TypedQuery<Account> query = entityManager.createQuery(hql, Account.class);
        return query.getResultList();
    }

    public Account getAccountById(int id) {
        String hql = "select a from Account a where a.id = :id";
        TypedQuery<Account> query = entityManager.createQuery(hql, Account.class).setParameter("id", id);
        return query.getSingleResult();
    }

    public void save(Account account) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(account);
        entityTransaction.commit();
    }

    public void update(Account account) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(account);
        entityTransaction.commit();
    }

    public void remove(Account account) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(account);
        entityTransaction.commit();
    }
}
