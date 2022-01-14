package com.youngman.model.business.services.gst;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.gst.PageableGstnRepository;
import com.youngman.model.model.customerportal.Gstn;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GstnServiceImpl implements GstnService {

    @Inject
    private PageableGstnRepository pageableGstnRepository;

    @Override
    public void delete(Gstn gstn) {
        pageableGstnRepository.delete(gstn);
    }

    @Override
    public Iterable<Gstn> findAll() {
        return pageableGstnRepository.findAll();
    }

    @Override
    public Optional<Gstn> getById(Long id) {
        return pageableGstnRepository.findById(id);
    }

    @Override
    public Gstn saveOrUpdate(Gstn gstn) throws ServiceException {
        return pageableGstnRepository.save(gstn);
    }
}
