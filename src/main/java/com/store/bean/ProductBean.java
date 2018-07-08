package com.store.bean;

import com.store.model.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.store.dao.ProductDao;

import java.util.ArrayList;
import java.util.List;

@Stateless(mappedName = "productBean")
public class ProductBean implements ProductBeanI {

    @PersistenceContext(unitName = "PRIMARY")
    public EntityManager em;

    @Override
    public Product add(Product product) {
        ProductDao pd = new ProductDao(em);
        return pd.save(product);
    }

    @Override
    public List<Product> viewAll() {
        ProductDao pd = new ProductDao(em);
        List<Product> products = pd.findAll();

        if(products == null)
            return new ArrayList<Product>();
        return products;
    }

    @Override
    public Product viewById(long id) {
        ProductDao pd = new ProductDao(em);
        return pd.findById(id);
    }

    @Override
    public Product update(Product product) {
        ProductDao pd = new ProductDao(em);
        return pd.merge(product);
    }

    @Override
    public boolean delete(long id) {
        ProductDao pd = new ProductDao(em);
        Product product = pd.findById(id);
        return pd.remove(product);
    }

}
