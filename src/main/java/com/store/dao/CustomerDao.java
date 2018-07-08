package com.store.dao;

import com.store.model.Customer;

import javax.persistence.EntityManager;

/**
 *
 */
public class CustomerDao extends GenericDao<Customer, Long> {

    public CustomerDao(EntityManager entityManager) {
        super(Customer.class, entityManager);
    }
}
