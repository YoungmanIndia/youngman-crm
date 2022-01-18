package com.youngman.core.business.repositories.gst;

import com.youngman.core.model.customerportal.Gstn;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageableGstnRepository extends PagingAndSortingRepository<Gstn, Long> {

    @Query("select distinct g from Gstn as g where g.gstn like %:gst% order by g.id")
    List<Gstn> findByGst(String gst, Pageable pageable);

    @Query("select distinct g from Gstn as g where g.customer.id = :customerId order by g.id")
    List<Gstn> findByCustomerId(Long customerId, Pageable pageable);
}
