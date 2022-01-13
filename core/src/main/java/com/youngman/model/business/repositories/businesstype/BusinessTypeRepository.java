package com.youngman.model.business.repositories.businesstype;

import com.youngman.model.model.customerportal.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {

}
