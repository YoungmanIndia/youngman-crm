package com.youngman.core.business.repositories.contactdesignation;

import com.youngman.core.model.customerportal.ContactDesignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDesignationRepository extends JpaRepository<ContactDesignation, Long> {

    @Query("select distinct c from ContactDesignation as c left join fetch c.groups cg join fetch c.merchantStore cm left join fetch c.defaultLanguage cl where c.id = ?1")
    ContactDesignation findOne(Long id);
}
