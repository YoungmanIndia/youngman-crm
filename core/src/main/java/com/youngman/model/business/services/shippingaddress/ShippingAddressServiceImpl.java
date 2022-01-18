package com.youngman.model.business.services.shippingaddress;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.shippingaddress.PageableShippingAddressRepository;
import com.youngman.model.business.repositories.shippingaddress.ShippingAddressRepository;
import com.youngman.model.model.customerportal.ShippingAddress;
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
