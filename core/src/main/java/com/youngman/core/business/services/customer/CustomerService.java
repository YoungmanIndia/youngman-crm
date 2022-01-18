package com.youngman.core.business.services.customer;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id) throws ServiceException;

    void saveOrUpdate(Customer customer) throws ServiceException;

    void delete(Customer customer);

    List<Customer> findAll();
}
