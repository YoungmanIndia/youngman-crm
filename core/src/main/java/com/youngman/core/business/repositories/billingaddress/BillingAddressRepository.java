package com.youngman.core.business.repositories.billingaddress;

import com.youngman.core.model.customerportal.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddressRepository, Long> {

    @Query("select distinct b from BillingAddress as b left join fetch b.groups bg join fetch b.merchantStore bm left join fetch b.defaultLanguage bl where b.id = ?1")
    BillingAddress findOne(Long id);
}
