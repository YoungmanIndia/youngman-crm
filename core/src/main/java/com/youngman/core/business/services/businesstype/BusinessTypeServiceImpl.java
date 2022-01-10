package com.youngman.core.business.services.businesstype;


import com.youngman.core.business.repositories.businesstype.BusinessTypeRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.BusinessType;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BusinessTypeServiceImpl extends YoungmanEntityServiceImpl<Long, BusinessType> implements BusinessTypeService {

    private BusinessTypeRepository businessTypeRepository;

    @Inject
    public BusinessTypeServiceImpl(BusinessTypeRepository businessTypeRepository) {
        super(businessTypeRepository);
        this.businessTypeRepository = businessTypeRepository;
    }
}
