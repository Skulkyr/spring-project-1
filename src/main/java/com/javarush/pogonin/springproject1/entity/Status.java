package com.javarush.pogonin.springproject1.entity;

public enum Status {
    IN_PROGRESS("In progress"),
    DONE("Done"),
    PAUSED("Paused");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}