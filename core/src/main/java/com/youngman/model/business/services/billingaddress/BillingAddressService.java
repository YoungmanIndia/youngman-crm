package com.youngman.model.business.services.billingaddress;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.customerportal.BillingAddress;

import java.util.List;

public interface BillingAddressService {

    BillingAddress getById(Long id);

    void saveOrUpdate(BillingAddress billingAddress) throws ServiceException;

    void delete(BillingAddress billingAddress);

    List<BillingAddress> findAll();

    List<BillingAddress> findByGst(String gst);

}
