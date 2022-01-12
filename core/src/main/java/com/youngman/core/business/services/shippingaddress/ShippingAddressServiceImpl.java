package com.youngman.core.business.services.shippingaddress;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.shippingaddress.PageableShippingAddressRepository;
import com.youngman.core.business.repositories.shippingaddress.ShippingAddressRepository;
import com.youngman.core.model.customerportal.ShippingAddress;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Inject
    private ShippingAddressRepository shippingAddressRepository;

    @Inject
    private PageableShippingAddressRepository pageableShippingAddressRepository;

    public ShippingAddressServiceImpl() {
    }

    @Override
    public void delete(ShippingAddress shippingAddress) {
        shippingAddressRepository.delete(shippingAddress);
    }

    @Override
    public List<ShippingAddress> findAll() {
        return shippingAddressRepository.findAll();
    }

    @Override
    public ShippingAddress getById(Long id) {
        return shippingAddressRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(ShippingAddress shippingAddress) throws ServiceException {
        shippingAddressRepository.save(shippingAddress);
    }
}
