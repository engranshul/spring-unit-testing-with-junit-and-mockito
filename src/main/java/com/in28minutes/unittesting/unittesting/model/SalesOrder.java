package com.in28minutes.unittesting.unittesting.model;

public class SalesOrder {
    private int id;
    private String category;

    public SalesOrder(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }
}
