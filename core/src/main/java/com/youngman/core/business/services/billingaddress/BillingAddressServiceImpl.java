package com.youngman.core.business.services.billingaddress;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.billingaddress.BillingAddressRepository;
import com.youngman.core.business.repositories.billingaddress.PageableBillingAddressRepository;
import com.youngman.core.model.customerportal.BillingAddress;
import com.youngman.core.model.customerportal.Gstn;
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

    @Override
    public List<BillingAddress> findByGst(String gst) {
        return billingAddressRepository.findByGst(gst);
    }
}