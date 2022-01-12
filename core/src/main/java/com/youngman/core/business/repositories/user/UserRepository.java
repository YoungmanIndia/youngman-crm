package com.youngman.core.business.repositories.user;

import com.youngman.core.model.crm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select distinct u from User as u where u.name like %:name% order by u.id")
    List<User> findByName(String name);

    @Query("select distinct u from User as u where u.email like %:email% order by u.id")
    List<User> findByEmail(String email);

    @Query("select distinct u from User as u where u.phone = :phone order by u.id")
    List<User> findByPhone(String phone);

    @Query("select distinct u from User as u where u.name = :userName ")
    User findByUserName(String userName);

    @Query("select distinct u from User as u where u.credentialsResetRequest.credentialsRequest = ?1")
    User findByResetPasswordToken(String token);
}
