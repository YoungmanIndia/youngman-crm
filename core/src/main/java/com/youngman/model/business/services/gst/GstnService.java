package com.youngman.model.business.services.gst;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.customerportal.Gstn;

import java.util.Optional;

public interface GstnService {

    Optional<Gstn> getById(Long id);

    Gstn saveOrUpdate(Gstn gstn) throws ServiceException;

    void delete(Gstn gstn);

    Iterable<Gstn> findAll();
}
