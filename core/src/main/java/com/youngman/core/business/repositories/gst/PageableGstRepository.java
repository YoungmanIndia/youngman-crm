package com.youngman.core.business.repositories.gst;

import com.youngman.core.model.customerportal.Gst;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageableGstRepository extends PagingAndSortingRepository<Gst, Long> {
}
