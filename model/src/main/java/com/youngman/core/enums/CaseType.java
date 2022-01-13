package com.youngman.core.enums;

import lombok.Getter;

public enum CaseType {

    SALES("SALES"), OPS("OPS"), ACCOUNTS("ACCOUNTS");

    @Getter
    private String caseType;

    CaseType(String caseType) {
        this.caseType = caseType;
    }
}
