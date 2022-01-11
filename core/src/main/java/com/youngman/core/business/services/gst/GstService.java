package com.youngman.core.business.services.gst;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.Gst;

import java.util.Optional;

public interface GstService {

    Optional<Gst> getById(Long id);

    Gst saveOrUpdate(Gst gst) throws ServiceException;

    void delete(Gst gst);

    Iterable<Gst> findAll();
}
