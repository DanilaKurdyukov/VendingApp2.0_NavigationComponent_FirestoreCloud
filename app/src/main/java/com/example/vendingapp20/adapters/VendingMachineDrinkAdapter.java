package com.example.vendingapp20.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vendingapp20.R;
import com.example.vendingapp20.models.VendingMachineDrink;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class VendingMachineDrinkAdapter extends RecyclerView.Adapter<VendingMachineDrinkAdapter.ViewHolder>{

    private Context mContext;
    private List<VendingMachineDrink> drinks;

    public VendingMachineDrinkAdapter(Context mContext, List<VendingMachineDrink> drinks) {
        this.mContext = mContext;
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VendingMachineDrinkAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.vending_machine_drink_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VendingMachineDrink current = drinks.get(position);
        holder.txtDrinkCost.setText(String.valueOf(current.getDrinkCost()));
        holder.txtDrinkName.setText(current.getDrinkName());

    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView txtDrinkName, txtDrinkCost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDrinkName = itemView.findViewById(R.id.text_view_drink_name);
            txtDrinkCost = itemView.findViewById(R.id.text_view_drink_cost);
        }
    }
}
