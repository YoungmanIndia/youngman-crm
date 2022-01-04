package com.youngman.core.enums;

import lombok.Getter;

public enum BusinessType {

    FR("FR"), IWM("IWM"), EVENT("EVENT"), FACILTIY("FACILITY");

    @Getter
    private String businessType;

    BusinessType(String businessType) {
        this.businessType = businessType;
    }
}
