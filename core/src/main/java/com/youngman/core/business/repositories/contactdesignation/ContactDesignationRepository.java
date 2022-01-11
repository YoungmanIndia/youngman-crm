package com.youngman.core.business.repositories.contactdesignation;

import com.youngman.core.model.customerportal.ContactDesignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDesignationRepository extends JpaRepository<ContactDesignation, Long> {
    @Query("select distinct c from ContactDesignation as c where c.gst like %:gst% order by c.id")
    List<ContactDesignation> findContactDesignationByGst(String gst);

    @Query("select distinct c from ContactDesignation as c where c.roleId like %:roleId% order by c.id")
    List<ContactDesignation> findContactDesignationByRoleId(Long roleId);

    @Query("select distinct c from ContactDesignation as c where c.contactId like %:contactId% order by c.id")
    List<ContactDesignation> findContactDesignationByContactId(Long contactId);

}
