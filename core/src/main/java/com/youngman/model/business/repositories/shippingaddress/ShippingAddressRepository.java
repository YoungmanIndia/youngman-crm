package com.youngman.model.business.repositories.shippingaddress;

import com.youngman.model.model.customerportal.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {

    @Query("select distinct s from ShippingAddress as s where s.city like %:city% order by s.id")
    List<ShippingAddress> findShippingAddressByCity(String city);

    @Query("select distinct s from ShippingAddress as s where s.pincode = :pincode order by s.id")
    List<ShippingAddress> findShippingAddressByPincode(Integer pincode);

    @Query("select distinct s from ShippingAddress as s where s.state like %:state% order by s.id")
    List<ShippingAddress> findShippingAddressByState(String state);
}
