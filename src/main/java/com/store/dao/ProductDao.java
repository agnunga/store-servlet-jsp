package com.store.dao;

import com.store.model.Product;
import javax.persistence.EntityManager;

/**
 *
 * */
public class ProductDao extends GenericDao<Product, Long> {

    public ProductDao(EntityManager entityManager) {
        super(Product.class, entityManager);
    }
}
