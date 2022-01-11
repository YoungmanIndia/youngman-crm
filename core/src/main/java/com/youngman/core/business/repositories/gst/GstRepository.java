package com.youngman.core.business.repositories.gst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GstRepository extends JpaRepository<GstRepository, Long> {

    @Query("select distinct g from Gst as g left join fetch g.groups gg join fetch g.merchantStore gm left join fetch g.defaultLanguage gl where g.id = ?1")
    Users findOne(Long id);
}
