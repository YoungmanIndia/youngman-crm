package com.youngman.core.business.services.customer;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.customer.CustomerRepository;
import com.youngman.core.business.repositories.customer.PageableCustomerRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.Customer;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;

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

    @Override
    public List<Customer> getByName(String name) throws ServiceException {
        return (List<Customer>) customerRepository.findByName(name);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void delete(Customer customer) throws ServiceException {
        Customer c = this.getById(customer.getId());
        super.delete(c);

    }

    @Override
    public List<Customer> listCustomer() throws ServiceException {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Customer getByPasswordResetToken(String storeCode, String token) {
        return customerRepository.findByResetPasswordToken(token, storeCode);
    }

    @Override
    public void saveOrUpdate(Customer customer) throws ServiceException {
        customerRepository.save(customer);
    }
}

