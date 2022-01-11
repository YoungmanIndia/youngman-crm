package com.youngman.core.business.services.shippingaddress;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.services.common.generic.YoungmanEntityService;
import com.youngman.core.model.customerportal.ShippingAddress;

public interface ShippingAddressService extends YoungmanEntityService<Long, ShippingAddress> {

    ShippingAddress getById(Long id);

    void saveOrUpdate(ShippingAddress shippingAddress) throws ServiceException;

}
