package com.store.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bitzero on 5/2/18.
 * @param <T>
 * @param <PK>
 */ 
public interface GenericDaoI<T, PK extends Serializable> {
    T save(T t);
    T findById(PK id);
    T merge(T t);
    List<T> findAll();
    boolean remove(T t);
}
