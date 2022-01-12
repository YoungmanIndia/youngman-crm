package com.youngman.core.business.services.shippingaddress;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    ShippingAddress getById(Long id);

    void saveOrUpdate(ShippingAddress shippingAddress) throws ServiceException;

    void delete(ShippingAddress shippingAddress);

    List<ShippingAddress> findAll();
}
