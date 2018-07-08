package com.store.bean;

import com.store.dao.CustomerDao;
import com.store.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless(mappedName = "customerBean")
public class CustomerBean implements CustomerBeanI {

    @PersistenceContext(unitName = "PRIMARY")
    public EntityManager em;

    @Override
    public Customer add(Customer customer) {
        CustomerDao pd = new CustomerDao(em);
        return pd.save(customer);
    }

    @Override
    public List<Customer> viewAll() {
        CustomerDao pd = new CustomerDao(em);
        List<Customer> customers = pd.findAll();

        if(customers == null)
            return new ArrayList<Customer>();
        return customers;
    }

    @Override
    public Customer viewById(long id) {
        CustomerDao pd = new CustomerDao(em);
        return pd.findById(id);
    }

    @Override
    public Customer update(Customer customer) {
        CustomerDao pd = new CustomerDao(em);
        return pd.merge(customer);
    }

    @Override
    public boolean delete(long id) {
        CustomerDao pd = new CustomerDao(em);
        Customer customer = pd.findById(id);
        return pd.remove(customer);
    }

}
