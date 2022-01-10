package com.youngman.core.business.services.customer;

import com.youngman.core.business.repositories.customer.CustomerRepository;
import com.youngman.core.business.repositories.customer.PageableCustomerRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.Customer;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CustomerServiceImpl extends YoungmanEntityServiceImpl<Long, Customer> implements CustomerService {

    private CustomerRepository customerRepository;

    private PageableCustomerRepository pageableCustomerRepository;

    @Inject
    public CustomerServiceImpl(CustomerRepository customerRepository, PageableCustomerRepository pageableCustomerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
        this.pageableCustomerRepository = pageableCustomerRepository;
    }
}

