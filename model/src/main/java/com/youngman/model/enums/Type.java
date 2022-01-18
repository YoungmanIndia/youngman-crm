package com.youngman.model.enums;

import lombok.Getter;

public enum Type {

    INT("INTERNAL"), EXT("EXTERNAL");

    @Getter
    private String type;

    Type(String type) {
        this.type = type;
    }
}
