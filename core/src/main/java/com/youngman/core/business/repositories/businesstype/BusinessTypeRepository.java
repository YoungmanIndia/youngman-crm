package com.youngman.core.business.repositories.businesstype;

import com.youngman.core.model.customerportal.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {

}
