package com.example.vendingapp20.models;

public class VendingMachineCoin {

    private int id;
    private int count;
    private boolean isActive;
    private int coinValue;

    public VendingMachineCoin() {
        // empty constructor
        // required for Firebase.
    }

    public VendingMachineCoin(int id, int count, boolean isActive, int coinValue) {
        this.id = id;
        this.count = count;
        this.isActive = isActive;
        this.coinValue = coinValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }
}
