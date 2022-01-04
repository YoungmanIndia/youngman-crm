package com.youngman.core.enums;

import lombok.Getter;

public enum CreditRating {

    A_RATING("A"), B_RATING("B"), C_RATING("C");

    @Getter
    private String rating;

    CreditRating(String rating) {
        this.rating = rating;
    }
}
