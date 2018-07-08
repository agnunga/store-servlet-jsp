package com.store.bean;

import com.store.model.Product;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductBeanI {

    Product add(Product product);

    List<Product> viewAll();

    Product viewById(long id);

    Product update(Product product);

    boolean delete(long id);
}
