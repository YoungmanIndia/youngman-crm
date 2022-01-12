package com.youngman.core.business.services.businesstype;


import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.businesstype.BusinessTypeRepository;
import com.youngman.core.model.customerportal.BusinessType;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessTypeServiceImpl implements BusinessTypeService {

    @Inject
    private BusinessTypeRepository businessTypeRepository;

    public BusinessTypeServiceImpl() {
    }

    @Override
    public void delete(BusinessType businessType) {
        businessTypeRepository.delete(businessType);
    }

    @Override
    public void saveOrUpdate(BusinessType businessType) throws ServiceException {
        businessTypeRepository.save(businessType);
    }

    @Override
    public List<BusinessType> findAll() {
        return businessTypeRepository.findAll();
    }

    @Override
    public BusinessType getById(Long id) {
        return businessTypeRepository.getById(id);
    }
}
