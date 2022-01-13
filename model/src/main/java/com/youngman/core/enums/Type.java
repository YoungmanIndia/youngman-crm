package com.youngman.core.enums;

import lombok.Getter;

public enum Type {

    INT("INTERNAL"), EXT("EXTERNAL");

    @Getter
    private String type;

    Type(String type) {
        this.type = type;
    }
}
