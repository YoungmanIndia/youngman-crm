package com.youngman.core.business.repositories.user;

import com.youngman.core.model.crm.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select distinct u from User as u left join fetch u.groups ug join fetch u.merchantStore um left join fetch u.defaultLanguage ul where u.adminName = ?1")
    Users findByUserName(String userName);

    @Query("select distinct u from User as u left join fetch u.groups ug join fetch u.merchantStore um left join fetch u.defaultLanguage ul where u.id = ?1")
    Users findOne(Long id);

    @Query("select distinct u from User as u left join fetch u.groups ug join fetch u.merchantStore um left join fetch u.defaultLanguage ul order by u.id")
    List<Users> findAll();

    @Query("select distinct u from User as u "
            + "left join fetch u.groups ug "
            + "join fetch u.merchantStore um "
            + "left join fetch u.defaultLanguage ul "
            + "where u.credentialsResetRequest.credentialsRequest = ?1 and um.code = ?2 ")
    Users findByResetPasswordToken(String token, String store);
}
