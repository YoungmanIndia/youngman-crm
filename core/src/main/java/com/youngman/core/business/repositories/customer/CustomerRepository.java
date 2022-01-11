package com.youngman.core.business.repositories.customer;

import com.youngman.core.enums.CreditRating;
import com.youngman.core.model.customerportal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select distinct c from Customer as c where c.panNo like %:panNo% order by c.id")
    List<Customer> findCustomersByPanNo(String panNo);

    @Query("select distinct c from Customer as c where c.companyName like %:companyName% order by c.id")
    List<Customer> findCustomersByCompanyName(String companyName);

    List<Customer> findCustomersByCreditRating(CreditRating creditRating);

}
