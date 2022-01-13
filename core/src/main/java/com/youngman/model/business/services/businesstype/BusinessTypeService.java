package com.youngman.model.business.services.businesstype;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.customerportal.BusinessType;

import java.util.List;

public interface BusinessTypeService {

    BusinessType getById(Long id);

    void saveOrUpdate(BusinessType businessType) throws ServiceException;

    void delete(BusinessType businessType);

    List<BusinessType> findAll();
}
