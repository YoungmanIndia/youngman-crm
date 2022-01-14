package com.youngman.model.business.services.billingaddress;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.billingaddress.BillingAddressRepository;
import com.youngman.model.business.repositories.billingaddress.PageableBillingAddressRepository;
import com.youngman.model.model.customerportal.BillingAddress;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {

    @Inject
    private BillingAddressRepository billingAddressRepository;

    @Inject
    private PageableBillingAddressRepository pageableBillingAddressRepository;

    public BillingAddressServiceImpl() {
    }

    @Override
    public void delete(BillingAddress billingAddress) {
        billingAddressRepository.delete(billingAddress);
    }

    @Override
    public List<BillingAddress> findAll() {
        return billingAddressRepository.findAll();
    }

    @Override
    public BillingAddress getById(Long id) {
        return billingAddressRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(BillingAddress billingAddress) throws ServiceException {
        billingAddressRepository.save(billingAddress);
    }
}