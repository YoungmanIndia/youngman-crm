package com.youngman.core.business.repositories.user;

import com.youngman.core.model.crm.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageableUserRepository extends PagingAndSortingRepository<Users, Long> {

    @Query("select distinct u from Users as u where u.name like %:name% order by u.id")
    List<Users> findByName(String name, Pageable pageable);

    @Query("select distinct u from Users as u where u.email like %:email% order by u.id")
    List<Users> findByEmail(String email, Pageable pageable);

    @Query("select distinct u from Users as u where u.phone = :phone order by u.id")
    List<Users> findByPhone(String phone, Pageable pageable);

}
