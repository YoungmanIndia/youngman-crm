package com.youngman.model.business.repositories.contact;

import com.youngman.model.model.customerportal.Contact;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageableContactRepository extends PagingAndSortingRepository<Contact, Long> {

    @Query("select distinct c from Contact as c where c.name like %:name% order by c.id")
    List<Contact> findContactByName(String name, Pageable pageable);

    @Query("select distinct c from Contact as c where c.email like %:email% order by c.id")
    List<Contact> findContactByEmail(String email, Pageable pageable);

    @Query("select distinct c from Contact as c where c.phone like %:phone% order by c.id")
    List<Contact> findContactByPhone(String phone, Pageable pageable);
}
