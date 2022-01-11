package com.youngman.core.business.repositories.shippingaddress;

import com.youngman.core.model.customerportal.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddressRepository, Long> {

    @Query("select distinct s from ShippingAddress as s left join fetch s.groups sg join fetch s.merchantStore sm left join fetch s.defaultLanguage sl where s.id = ?1")
    ShippingAddress findOne(Long id);
}
