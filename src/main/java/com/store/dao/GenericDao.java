package com.store.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;   

/**
 *
 * @param <T>
 * @param <PK>
 */
public class GenericDao<T, PK extends Serializable> implements GenericDaoI<T, PK> {

    private Class<T> entityClass;
    private EntityManager entityManager;

    public GenericDao(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    @Override
    public T save(T t) {
        try {
            this.entityManager.persist(t);
            return t;
        } catch (Exception ep) {
            ep.printStackTrace();
            return null;
        }
    }

    @Override
    public T findById(PK id) {
        try {
            return this.entityManager.find(entityClass, id);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            return null;
        }
    }

    @Override
    public T merge(T t) {
        try {
            this.entityManager.merge(t);
            return t;
        } catch (Exception pe) {
            pe.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        return this.entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t").getResultList();
    }

    @Override
    public boolean remove(T t) {
        try {
            t = this.entityManager.merge(t);
            this.entityManager.remove(t);
            return true;
        } catch (Exception pe) {
            pe.printStackTrace();
            return false;
        }
    }
}
