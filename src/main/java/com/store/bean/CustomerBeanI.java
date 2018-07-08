package com.store.bean;

import com.store.model.Customer;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerBeanI {

    Customer add(Customer customer);

    List<Customer> viewAll();

    Customer viewById(long id);

    Customer update(Customer customer);

    boolean delete(long id);
}
