package com.youngman.core.business.repositories.user;

import com.youngman.core.model.crm.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageableUserRepository extends PagingAndSortingRepository<Users, Long> {
    @Query(value = "select distinct u from Users as u left join fetch u.groups ug left join fetch ug.permissions ugp left join fetch u.defaultLanguage ud join fetch u.merchantStore um where (?1 is null or u.adminEmail like %?1%)",
            countQuery = "select count(distinct u) from User as u join u.groups ug join ug.permissions ugp join u.merchantStore um where (?1 is null or u.adminEmail like %?1%)")
    Page<Users> listAll(String email, Pageable pageable);
}
