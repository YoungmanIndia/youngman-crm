package com.youngman.model.business.services.common.generic;

import com.youngman.model.business.exception.ServiceException;

import java.io.Serializable;
import java.util.List;

public interface YoungmanEntityService <K extends Serializable & Comparable<K>, E extends com.youngman.model.model.generic.YoungmanEntity<K, ?>> extends TransactionalAspectAwareService{

    void save(E entity) throws ServiceException;

    void update(E entity) throws ServiceException;

    void create(E entity) throws ServiceException;

    void delete(E entity) throws ServiceException;

    E getById(K id);

    List<E> list();

    Long count();

    void flush();

}
