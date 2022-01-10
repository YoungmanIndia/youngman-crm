package com.youngman.core.business.repositories.customer;

import com.youngman.core.model.customerportal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select distinct c from Customer as c left join fetch c.groups cg join fetch c.merchantStore cm left join fetch c.defaultLanguage cl where c.adminName = ?1")
    Customer findByName(String name);

    @Query("select distinct c from Customer as c left join fetch c.groups cg join fetch c.merchantStore cm left join fetch c.defaultLanguage cl where c.id = ?1")
    Customer findOne(Long id);

    @Query("select distinct c from Customer as c left join fetch c.groups cg join fetch c.merchantStore cm left join fetch c.defaultLanguage cl order by c.id")
    List<Customer> findAll();

    @Query("select distinct c from Customer as c "
            + "left join fetch c.groups cg "
            + "join fetch c.merchantStore cm "
            + "left join fetch c.defaultLanguage cl "
            + "where c.credentialsResetRequest.credentialsRequest = ?1 and cm.code = ?2 ")
    Customer findByResetPasswordToken(String token, String store);

}
