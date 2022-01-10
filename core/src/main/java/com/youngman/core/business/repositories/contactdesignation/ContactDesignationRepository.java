package com.youngman.core.business.repositories.contactdesignation;

import com.youngman.core.model.customerportal.ContactDesignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDesignationRepository extends JpaRepository<ContactDesignation, Long> {
}
