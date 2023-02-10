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

        public VendingMachineDrink() {
                // empty constructor
                // required for Firebase.
        }

        protected VendingMachineDrink(Parcel in) {
                id = in.readInt();
                count = in.readInt();
                drinkName = in.readString();
                drinkCost = in.readInt();
                drinkImage = in.readString();
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

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(id);
                dest.writeInt(count);
                dest.writeString(drinkName);
                dest.writeInt(drinkCost);
                dest.writeString(drinkImage);
        }
}
