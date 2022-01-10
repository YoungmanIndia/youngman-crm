package com.youngman.core.business.services.customer;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getByName(String name) throws ServiceException;

    List<Customer> listCustomer() throws ServiceException;

    Customer getById(Long id);

    Customer getByPasswordResetToken(String storeCode, String token);

    void saveOrUpdate(Customer customer) throws ServiceException;
}
