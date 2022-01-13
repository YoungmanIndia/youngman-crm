package com.youngman.core.enums;

import lombok.Getter;

public enum Priority {

    LOW("LOW"), MED("MEDIUM"), HIGH("HIGH");

    @Getter
    private String priority;

    Priority(String priority) {
        this.priority = priority;
    }
}
