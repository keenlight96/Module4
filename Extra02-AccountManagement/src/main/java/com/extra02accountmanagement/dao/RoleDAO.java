package com.extra02accountmanagement.dao;

import com.extra02accountmanagement.model.Role;
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


}
