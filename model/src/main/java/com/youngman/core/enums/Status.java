package com.youngman.core.enums;

import lombok.Getter;

public enum Status {

    ACTIVE("A"), INACTIVE("I");

    @Getter
    private String status;

    Status(String status) {
        this.status = status;
    }
}
