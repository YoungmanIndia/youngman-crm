package com.youngman.core.business.repositories.contact;

import com.youngman.core.model.customerportal.Contact;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select distinct c from Contact as c where c.name like %:name% order by c.id")
    List<Contact> findContactByName(String name);

    @Query("select distinct c from Contact as c where c.email like %:email% order by c.id")
    List<Contact> findContactByEmail(String email);

    @Query("select distinct c from Contact as c where c.phone like %:phone% order by c.id")
    List<Contact> findContactByPhone(String phone);


}
