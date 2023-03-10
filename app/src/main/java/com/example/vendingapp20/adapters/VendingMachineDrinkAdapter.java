package com.example.vendingapp20.adapters;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vendingapp20.R;
import com.example.vendingapp20.models.VendingMachineDrink;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VendingMachineDrinkAdapter extends RecyclerView.Adapter<VendingMachineDrinkAdapter.ViewHolder>{

    public interface ItemClickListener{
        void onClick(VendingMachineDrink vendingMachineDrink);
    }

    private ItemClickListener itemClickListener;

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
        holder.txtDrinkCost.setText(String.valueOf(current.getDrinkCost()) + " руб.");
        holder.txtDrinkName.setText(current.getDrinkName());
        if (current.getCount()<=0){
            holder.drinkSoldOut.setVisibility(View.VISIBLE);
            holder.txtDrinkCost.setVisibility(View.GONE);
            holder.txtDrinkName.setVisibility(View.GONE);
            holder.drinkImage.setVisibility(View.GONE);
            Picasso.get().load(current.getDrinkOutImage()).into(holder.drinkSoldOut);
        }else{
            holder.drinkSoldOut.setVisibility(View.GONE);
            holder.txtDrinkCost.setVisibility(View.VISIBLE);
            holder.txtDrinkName.setVisibility(View.VISIBLE);
            holder.drinkImage.setVisibility(View.VISIBLE);
        }
        if (current.getDrinkImage()!=null){
            Picasso.get().load(current.getDrinkImage()).into(holder.drinkImage);
        }
        if (itemClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(current);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView txtDrinkName, txtDrinkCost;
        private ImageView drinkImage,drinkSoldOut;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDrinkName = itemView.findViewById(R.id.text_view_drink_name);
            txtDrinkCost = itemView.findViewById(R.id.text_view_drink_cost);
            drinkImage = itemView.findViewById(R.id.drink_image);
            drinkSoldOut = itemView.findViewById(R.id.drinkSoldOut);
        }
    }
}
