package com.youngman.model.business.services.shippingaddress;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.customerportal.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    ShippingAddress getById(Long id);

    void saveOrUpdate(ShippingAddress shippingAddress) throws ServiceException;

    void delete(ShippingAddress shippingAddress);

    List<ShippingAddress> findAll();
}
