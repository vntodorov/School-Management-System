package com.iStudent.model.entity.enums;

public enum Mark {
    POOR(2),
    AVERAGE(3),
    GOOD(4),
    VERY_GOOD(5),
    EXCELLENT(6);

    private int value;

    Mark(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
