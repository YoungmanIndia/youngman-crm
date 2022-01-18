package com.youngman.crm.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youngman.model.model.customerportal.BillingAddress;

public class BillingAddressVo {
    private Long id;

    @JsonProperty("customerId")
    private Long customerId;

    @JsonProperty("gst")
    private String gst;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("pincode")
    private Integer pincode;

    @JsonProperty("state")
    private String state;

    @JsonProperty("status")
    private String status;

    public BillingAddressVo() {
    }

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
