package com.youngman.core.business.services.shippingaddress;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.shippingaddress.PageableShippingAddressRepository;
import com.youngman.core.business.repositories.shippingaddress.ShippingAddressRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.ShippingAddress;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ShippingAddressServiceImpl extends YoungmanEntityServiceImpl<Long, ShippingAddress> implements ShippingAddressService{

    private ShippingAddressRepository shippingAddressRepository;

    private PageableShippingAddressRepository pageableShippingAddressRepository;

    @Inject
    public ShippingAddressServiceImpl(ShippingAddressRepository shippingAddressRepository, PageableShippingAddressRepository pageableShippingAddressRepository) {
        super(shippingAddressRepository);
        this.shippingAddressRepository = shippingAddressRepository;
        this.pageableShippingAddressRepository = pageableShippingAddressRepository;
    }

    @Override
    public void delete(ShippingAddress shippingAddress) throws ServiceException {
        ShippingAddress s = this.getById(shippingAddress.getId());
        super.delete(s);

    }

    @Override
    public void saveOrUpdate(ShippingAddress shippingAddress) throws ServiceException {
        shippingAddressRepository.save(shippingAddress);
    }
}
