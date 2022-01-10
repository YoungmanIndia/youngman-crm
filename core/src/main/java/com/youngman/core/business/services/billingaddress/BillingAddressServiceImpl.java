package com.youngman.core.business.services.billingaddress;

import com.youngman.core.business.repositories.billingaddress.BillingAddressRepository;
import com.youngman.core.business.repositories.billingaddress.PageableBillingAddressRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.BillingAddress;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BillingAddressServiceImpl extends YoungmanEntityServiceImpl<Long, BillingAddress> implements BillingAddressService {

    private BillingAddressRepository billingAddressRepository;

    private PageableBillingAddressRepository pageableBillingAddressRepository;

    @Inject
    public BillingAddressServiceImpl(BillingAddressRepository billingAddressRepository, PageableBillingAddressRepository pageableBillingAddressRepository) {
        super(billingAddressRepository);
        this.billingAddressRepository = billingAddressRepository;
        this.pageableBillingAddressRepository = pageableBillingAddressRepository;
    }
}