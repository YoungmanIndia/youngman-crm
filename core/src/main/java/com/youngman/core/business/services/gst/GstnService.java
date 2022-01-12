package com.youngman.core.business.services.gst;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.Gstn;

import java.util.Optional;

public interface GstnService {

    Optional<Gstn> getById(Long id);

    Gstn saveOrUpdate(Gstn gstn) throws ServiceException;

    void delete(Gstn gstn);

    Iterable<Gstn> findAll();
}
