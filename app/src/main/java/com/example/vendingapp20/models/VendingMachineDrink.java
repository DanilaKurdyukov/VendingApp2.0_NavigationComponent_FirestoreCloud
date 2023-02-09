package com.example.vendingapp20.models;

public class VendingMachineDrink {

        private int id;
        private int machineId;
        private int drinkId;
        private int count;
        private String drinkName;
        private int drinkCost;
        private String drinkImage;

        public VendingMachineDrink(int id, int machineId, int drinkId, int count, String drinkName, int drinkCost) {
                this.id = id;
                this.machineId = machineId;
                this.drinkId = drinkId;
                this.count = count;
                this.drinkName = drinkName;
                this.drinkCost = drinkCost;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getMachineId() {
                return machineId;
        }

        public void setMachineId(int machineId) {
                this.machineId = machineId;
        }

        public int getDrinkId() {
                return drinkId;
        }

        public void setDrinkId(int drinkId) {
                this.drinkId = drinkId;
        }

        public int getCount() {
                return count;
        }

        public void setCount(int count) {
                this.count = count;
        }

        public String getDrinkName() {
                return drinkName;
        }

        public void setDrinkName(String drinkName) {
                this.drinkName = drinkName;
        }

        public int getDrinkCost() {
                return drinkCost;
        }

        public void setDrinkCost(int drinkCost) {
                this.drinkCost = drinkCost;
        }
}
