package com.youngman.core.business.services.billingaddress;

import com.youngman.core.model.customerportal.BillingAddress;

public interface BillingAddressService extends YoungmanEntityService<Long, BillingAddress> {

    BillingAddress getById(Long id);

    void saveOrUpdate(BillingAddress billingAddress) throws ServiceException;

}
