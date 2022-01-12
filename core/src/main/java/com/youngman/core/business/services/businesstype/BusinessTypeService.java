package com.youngman.core.business.services.businesstype;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.BusinessType;

import java.util.List;

public interface BusinessTypeService {

    BusinessType getById(Long id);

    void saveOrUpdate(BusinessType businessType) throws ServiceException;

    void delete(BusinessType businessType);

    List<BusinessType> findAll();
}
