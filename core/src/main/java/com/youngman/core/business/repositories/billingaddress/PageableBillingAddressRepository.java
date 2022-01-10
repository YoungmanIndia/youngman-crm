package com.youngman.core.business.repositories.billingaddress;

import com.youngman.core.model.customerportal.BillingAddress;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageableBillingAddressRepository extends PagingAndSortingRepository<BillingAddress, Long> {

    @Query("select distinct b from BillingAddress as b where b.gst like %:gst% order by b.id")
    List<BillingAddress> findBillingAddressByGst(String gst, Pageable pageable);

    @Query("select distinct b from BillingAddress as b where b.status like %:status% order by b.id")
    List<BillingAddress> findBillingAddressByStatus(String status, Pageable pageable);

    @Query("select distinct b from BillingAddress as b where b.city like %:city% order by b.id")
    List<BillingAddress> findBillingAddressByCity(String city, Pageable pageable);

    @Query("select distinct b from BillingAddress as b where b.pincode = :pincode order by b.id")
    List<BillingAddress> findBillingAddressByPincode(Integer pincode, Pageable pageable);

    @Query("select distinct b from BillingAddress as b where b.state like %:state% order by b.id")
    List<BillingAddress> findBillingAddressByState(String state, Pageable pageable);
}
