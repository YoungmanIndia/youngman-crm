package com.youngman.core.business.services.gst;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.gst.PageableGstRepository;
import com.youngman.core.model.customerportal.Gst;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GstServiceImpl implements GstService {

    @Inject
    private PageableGstRepository pageableGstRepository;

    @Override
    public void delete(Gst gst) {
        pageableGstRepository.delete(gst);
    }

    @Override
    public Iterable<Gst> findAll() {
        return pageableGstRepository.findAll();
    }

    @Override
    public Optional<Gst> getById(Long id) {
        return pageableGstRepository.findById(id);
    }

    @Override
    public Gst saveOrUpdate(Gst gst) throws ServiceException {
        return pageableGstRepository.save(gst);
    }
}
