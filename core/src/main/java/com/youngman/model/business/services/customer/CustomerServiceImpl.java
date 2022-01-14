package com.youngman.model.business.services.customer;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.customer.CustomerRepository;
import com.youngman.model.business.repositories.customer.PageableCustomerRepository;
import com.youngman.model.model.customerportal.Customer;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private PageableCustomerRepository pageableCustomerRepository;

    public CustomerServiceImpl() {
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(Customer customer) throws ServiceException {
        customerRepository.save(customer);
    }
}

