package com.youngman.core.business.repositories.businesstype;

import com.youngman.core.model.crm.Users;
import com.youngman.core.model.customerportal.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessTypeRepository extends JpaRepository<BusinessTypeRepository, Long> {

    @Query("select distinct u from User as u left join fetch u.groups ug join fetch u.merchantStore um left join fetch u.defaultLanguage ul where u.id = ?1")
    BusinessType findOne(Long id);
}
