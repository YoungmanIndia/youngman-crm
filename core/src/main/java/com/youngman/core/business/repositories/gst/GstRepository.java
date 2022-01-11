package com.youngman.core.business.repositories.gst;

import com.youngman.core.model.customerportal.Gst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GstRepository extends JpaRepository<Gst, Long> {

    @Query("select distinct g from Gst as g where g.gst like %:gst% order by g.id")
    List<Gst> findByGst(String gst);

    @Query("select distinct g from Gst as g where g.customerId = :customerId order by g.id")
    List<Gst> findByCustomerId(Long customerId);
}
