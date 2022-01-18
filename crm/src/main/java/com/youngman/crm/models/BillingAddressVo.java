package com.youngman.crm.models;

import com.youngman.core.model.customerportal.BillingAddress;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BillingAddressVo {
    private Long id;
    private Long customerId;
    private String gst;
    private String address;
    private String city;
    private Integer pincode;
    private String state;
    private String status;

    public BillingAddressVo(BillingAddress billingAddress) {
        this.customerId = billingAddress.getCustomer().getId();
        //TODO: ajay
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
