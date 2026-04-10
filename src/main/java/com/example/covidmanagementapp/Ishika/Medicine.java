package com.example.covidmanagementapp.Ishika;

public class Medicine {

    private String name;
    private int quantity;

    // Constructor
    public Medicine(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Auto-calculated status
    public String getStatus() {
        if (quantity == 0) {
            return "Out of Stock";
        } else if (quantity < 15) {
            return "Low Stock";
        } else {
            return "Available";
        }
    }
}