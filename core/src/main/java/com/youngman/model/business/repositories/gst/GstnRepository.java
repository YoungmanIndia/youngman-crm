package com.youngman.model.business.repositories.gst;

import com.youngman.model.model.customerportal.Gstn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GstnRepository extends JpaRepository<Gstn, Long> {

    @Query("select distinct g from Gstn as g where g.gstn = :gst")
    Gstn findByGst(String gst);

    @Query("select distinct g from Gstn as g where g.customer = :customerId order by g.id")
    List<Gstn> findByCustomerId(Long customerId);
}
