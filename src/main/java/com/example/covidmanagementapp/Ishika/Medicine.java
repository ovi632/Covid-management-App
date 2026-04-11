package com.example.covidmanagementapp.Ishika;

import java.io.Serializable;

public class Medicine implements Serializable {

    private String name;
    private int quantity;
    private String status;

    public Medicine(String name, int quantity, String status) {
        this.name = name;
        this.quantity = quantity;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}