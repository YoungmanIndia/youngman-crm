package com.youngman.core.business.repositories.gst;

import com.youngman.core.model.customerportal.Gstn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GstnRepository extends JpaRepository<Gstn, Long> {

    @Query("select distinct g from Gstn as g where g.gstn like %:gst% order by g.id")
    List<Gstn> findByGst(String gst);

    @Query("select distinct g from Gstn as g where g.customerId = :customerId order by g.id")
    List<Gstn> findByCustomerId(Long customerId);
}
