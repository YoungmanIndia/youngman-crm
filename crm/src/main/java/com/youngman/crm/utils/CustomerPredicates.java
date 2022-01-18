package com.youngman.crm.utils;


import com.youngman.model.model.customerportal.Customer;

import java.util.function.BiPredicate;

public class CustomerPredicates {

    private CustomerPredicates() {
    }

    public static BiPredicate<String, Customer> doesGstBelongToCustomer = (gst, customer) -> {
        String pan = Utils.findPan(gst);
        return customer.getPanNo().equalsIgnoreCase(pan);
    };
}
