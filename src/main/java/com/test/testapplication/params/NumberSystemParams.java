package com.test.testapplication.params;

public class NumberSystemParams {
    private Integer number;
    private Integer base;

    public NumberSystemParams(Integer number, Integer base) {
        this.number = number;
        this.base = base;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }
}
