package com.youngman.core.business.repositories.businesstype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessTypeRepository extends JpaRepository<BusinessTypeRepository, Long> {
}
