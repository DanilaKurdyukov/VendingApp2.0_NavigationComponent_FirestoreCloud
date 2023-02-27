package com.example.vendingapp20.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class VendingMachineDrink implements Parcelable {

        private int count;
        private int drinkCost;
        private String drinkName;
        private int id;
        private String drinkImage;
        private String drinkOutImage;

        public VendingMachineDrink(int count, int drinkCost, String drinkName, int id, String drinkImage, String drinkOutImage) {
                this.count = count;
                this.drinkCost = drinkCost;
                this.drinkName = drinkName;
                this.id = id;
                this.drinkImage = drinkImage;
                this.drinkOutImage = drinkOutImage;
        }

        public VendingMachineDrink() {
                // empty constructor
                // required for Firebase.
        }

        protected VendingMachineDrink(Parcel in) {
                count = in.readInt();
                drinkCost = in.readInt();
                drinkName = in.readString();
                id = in.readInt();
                drinkImage = in.readString();
                drinkOutImage = in.readString();
        }

        public static final Creator<VendingMachineDrink> CREATOR = new Creator<VendingMachineDrink>() {
                @Override
                public VendingMachineDrink createFromParcel(Parcel in) {
                        return new VendingMachineDrink(in);
                }

                @Override
                public VendingMachineDrink[] newArray(int size) {
                        return new VendingMachineDrink[size];
                }
        };

        public String getDrinkImage() {
                return drinkImage;
        }

        public void setDrinkImage(String drinkImage) {
                this.drinkImage = drinkImage;
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

        public String getDrinkOutImage() {
                return drinkOutImage;
        }

        public void setDrinkOutImage(String drinkOutImage) {
                this.drinkOutImage = drinkOutImage;
        }

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(count);
                dest.writeInt(drinkCost);
                dest.writeString(drinkName);
                dest.writeInt(id);
                dest.writeString(drinkImage);
                dest.writeString(drinkOutImage);
        }
}
