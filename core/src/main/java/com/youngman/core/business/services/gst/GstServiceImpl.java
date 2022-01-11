package com.youngman.core.business.services.gst;

import com.youngman.core.business.repositories.gst.GstRepository;
import com.youngman.core.business.repositories.gst.PageableGstRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.Gst;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class GstServiceImpl extends YoungmanEntityServiceImpl<Long, Gst> implements GstService {

    private GstRepository gstRepository;

    private PageableGstRepository pageableGstRepository;

    @Inject
    public GstServiceImpl(GstRepository gstRepository, PageableGstRepository pageableGstRepository) {
        super(gstRepository);
        this.gstRepository = gstRepository;
        this.pageableGstRepository = pageableGstRepository;
    }

    @Override
    public void delete(Gst gst) throws ServiceException {
        Gst g = this.getById(gst.getId());
        super.delete(g);

    }

    @Override
    public void saveOrUpdate(Gst gst) throws ServiceException {
        gstRepository.save(gst);
    }
}
