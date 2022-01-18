package com.youngman.model.business.services.customer;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.customerportal.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id) throws ServiceException;

    void saveOrUpdate(Customer customer) throws ServiceException;

    void delete(Customer customer);

    List<Customer> findAll();
}
