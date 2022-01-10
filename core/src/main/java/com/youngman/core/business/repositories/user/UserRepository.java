package com.youngman.core.business.repositories.user;

import com.youngman.core.model.crm.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select distinct u from User as u where u.name = ?1")
    Users findByUserName(String userName);

    @Query("select distinct u from User as u where u.id = ?1")
    Users findOne(Long id);

    @Query("select distinct u from User as u order by u.id")
    List<Users> findAll();

//    @Query("select distinct u from User as u ")
//    Users findByResetPasswordToken(String token, String store);
}
