package com.nidhogg.studyspringproject.domain.model.transaction;

public enum Category {

    SLR("Salary"),
    GFT("Gift"),
    TRF("Transfer"),
    TRP("Transport"),
    EDU("Education"),
    PDT("Products"),
    FNS("Fines"),
    HFT("Health and fitness"),
    PSV("Public service");

    private String name;

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
