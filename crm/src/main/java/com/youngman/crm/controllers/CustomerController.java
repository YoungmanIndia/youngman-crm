package com.youngman.crm.controllers;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.services.billingaddress.BillingAddressService;
import com.youngman.core.business.services.customer.CustomerService;
import com.youngman.core.business.services.gst.GstnService;
import com.youngman.core.enums.Status;
import com.youngman.core.model.customerportal.BillingAddress;
import com.youngman.core.model.customerportal.Customer;
import com.youngman.core.model.customerportal.Gstn;
import com.youngman.crm.models.BillingAddressVo;
import com.youngman.crm.utils.CustomerPredicates;
import com.youngman.crm.utils.Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/addBranch")
    public String addGstBranch(@NotNull @RequestParam("gst") String gst,@NotNull @RequestParam("customerId") Long customerId, @RequestParam("billingAddress") BillingAddressVo billingAddressVo) throws ServiceException {

        Customer customer = customerService.getById(customerId);

        if(CustomerPredicates.doesGstBelongToCustomer.test(gst, customer)) {
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
