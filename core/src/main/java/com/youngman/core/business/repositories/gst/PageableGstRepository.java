package com.youngman.core.business.repositories.gst;

import com.youngman.core.model.customerportal.Gst;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageableGstRepository extends PagingAndSortingRepository<Gst, Long> {

    @Query("select distinct g from Gst as g where g.gst like %:gst% order by g.id")
    List<Gst> findByGst(String gst, Pageable pageable);

    @Query("select distinct g from Gst as g where g.customerId = :customerId order by g.id")
    List<Gst> findByCustomerId(Long customerId, Pageable pageable);
}
