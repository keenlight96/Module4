package com.extra03_loginregister.dao;

import com.extra03_loginregister.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RoleDAO {
    @Autowired
    EntityManager entityManager;

    public List<Role> getRoles() {
        String hql = "select r from Role r";
        TypedQuery<Role> query = entityManager.createQuery(hql, Role.class);
        return query.getResultList();
    }

    public Role getRoleById(int id) {
        String hql = "select r from Role r where r.id = :id";
        TypedQuery<Role> query = entityManager.createQuery(hql, Role.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
