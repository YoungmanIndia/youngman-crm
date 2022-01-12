package com.youngman.core.business.repositories.billingaddress;

import com.youngman.core.model.customerportal.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {

    @Query("select distinct b from BillingAddress as b where b.pincode = :pincode order by b.id")
    List<BillingAddress> findByPincode(Integer pincode);

    @Query("select distinct b from BillingAddress as b where b.gst like %:gst% order by b.id")
    List<BillingAddress> findByGst(String gst);

    @Query("select distinct b from BillingAddress as b where b.state like %:state% order by b.id")
    List<BillingAddress> findByState(String state);

}
