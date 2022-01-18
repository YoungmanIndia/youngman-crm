package com.youngman.crm.controllers;


import com.youngman.crm.models.BillingAddressVo;
import com.youngman.crm.utils.CustomerPredicates;
import com.youngman.crm.utils.Utils;
import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.services.billingaddress.BillingAddressService;
import com.youngman.model.business.services.customer.CustomerService;
import com.youngman.model.business.services.gst.GstnService;
import com.youngman.model.enums.Status;
import com.youngman.model.model.customerportal.BillingAddress;
import com.youngman.model.model.customerportal.Customer;
import com.youngman.model.model.customerportal.Gstn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Inject
    private GstnService gstnService;

    @Inject
    private BillingAddressService billingAddressService;

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping(value = "/addBranch/{gst}/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public String addGstBranch(@NotNull @PathVariable("gst") String gst,@NotNull @PathVariable("customerId") Long customerId, @RequestBody BillingAddressVo billingAddressVo) {

        try {
            Customer customer = customerService.getById(customerId);

            if (CustomerPredicates.doesGstBelongToCustomer.test(gst, customer)) {
                Gstn gstn = new Gstn.GstnBuilder().setCustomer(customer).setGstn(gst).build();
                Gstn savedGstn = gstnService.saveOrUpdate(gstn);

                BillingAddress billingAddress = new BillingAddress.BillingAddressBuilder()
                        .setCustomer(customer)
                        .setGst(savedGstn)
                        .setAddress(billingAddressVo.getAddress())
                        .setCity(billingAddressVo.getCity())
                        .setPincode(billingAddressVo.getPincode())
                        .setState(billingAddressVo.getState())
                        .setStatus(Status.ACTIVE.getStatus())
                        .build();

                savedGstn.getBillingAddresses().add(billingAddress);

                billingAddressService.saveOrUpdate(billingAddress);

            } else {
                throw new ServiceException("Gst " + gst + " does not belong to customer " + customer);
            }

        } catch (ServiceException e) {
            logger.error("Exception in Class CustomerController", e);
            return e.getMessageCode();
        }

        return "Branch added successfully";
    }

    @PostMapping(value = "/viewBranch")
    public List<Gstn> viewGstBranch(@NotNull @RequestParam("customerId") Long customerId) {
        List<Gstn> gstnList = gstnService.findByCustomerId(customerId);
        return gstnList;
    }

    @PostMapping(value = "/getAllGst")
    public List<Gstn> getAllGst(@NotNull @RequestParam("customerId") Long customerId) {
        List<Gstn> gstn = gstnService.findByCustomerId(customerId);
        return gstn;
    }

    @PostMapping(value = "/getBillingAddress")
    public List<BillingAddressVo> getBillingAddress(@NotNull @RequestParam("gst") String gst) {
        Gstn gstn = gstnService.findByGst(gst);
        List<BillingAddress> billingAddresses = gstn.getBillingAddresses();
        return billingAddresses.stream().map(BillingAddressVo::new).collect(Collectors.toList());
    }

}
