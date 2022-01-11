package com.youngman.core.business.repositories.contact;

import com.youngman.core.model.customerportal.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactRepository, Long> {

    @Query("select distinct c from Contact as c left join fetch c.groups cg join fetch c.merchantStore cm left join fetch c.defaultLanguage cl where c.adminName = ?1")
    Contact findByName(String name);

    @Query("select distinct c from Contact as c left join fetch c.groups cg join fetch c.merchantStore cm left join fetch c.defaultLanguage cl where c.id = ?1")
    Contact findOne(Long id);

    @Query("select distinct c from Contact as c left join fetch c.groups cg join fetch c.merchantStore cm left join fetch c.defaultLanguage cl order by c.id")
    List<Contact> findAll();
}
