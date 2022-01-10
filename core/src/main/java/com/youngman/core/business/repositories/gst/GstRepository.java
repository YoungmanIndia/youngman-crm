package com.youngman.core.business.repositories.gst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GstRepository extends JpaRepository<GstRepository, Long> {
}
