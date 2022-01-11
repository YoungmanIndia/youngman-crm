package com.youngman.core.business.services.gst;

import com.youngman.core.model.customerportal.Gst;

public interface GstService extends YoungmanEntityService<Long, Gst>{

    Gst getById(Long id);

    void saveOrUpdate(Gst gst) throws ServiceException;

}
