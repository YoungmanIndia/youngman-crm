package com.youngman.core.business.services.businesstype;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.services.common.generic.YoungmanEntityService;
import com.youngman.core.model.customerportal.BusinessType;

public interface BusinessTypeService extends YoungmanEntityService<Long, BusinessType> {

    BusinessType getById(Long id);

    void saveOrUpdate(BusinessType businessType) throws ServiceException;

}
