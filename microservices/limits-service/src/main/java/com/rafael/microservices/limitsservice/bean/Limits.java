package com.rafael.microservices.limitsservice.bean;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Limits {

    private int minimum;
    private int maximum;

    public Limits(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
