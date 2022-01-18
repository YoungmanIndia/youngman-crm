package com.youngman.model.business.services.common.generic;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.generic.YoungmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class YoungmanEntityServiceImpl <K extends Serializable & Comparable<K>, E extends YoungmanEntity<K, ?>> implements YoungmanEntityService<K, E>{

    private Class<E> objectClass;


    private JpaRepository<E, K> repository;

    @SuppressWarnings("unchecked")
    public YoungmanEntityServiceImpl(JpaRepository<E, K> repository) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.objectClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
        this.repository = repository;
    }

    protected final Class<E> getObjectClass() {
        return objectClass;
    }


    public E getById(K id) {
        return repository.getOne(id);
    }


    public void save(E entity) throws ServiceException {
        repository.saveAndFlush(entity);
    }


    public void create(E entity) throws ServiceException {
        save(entity);
    }



    public void update(E entity) throws ServiceException {
        save(entity);
    }


    public void delete(E entity) throws ServiceException {
        repository.delete(entity);
    }


    public void flush() {
        repository.flush();
    }



    public List<E> list() {
        return repository.findAll();
    }


    public Long count() {
        return repository.count();
    }

    protected E saveAndFlush(E entity) {
        return repository.saveAndFlush(entity);
    }
}
