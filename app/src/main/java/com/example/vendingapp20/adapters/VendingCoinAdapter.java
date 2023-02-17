package com.example.vendingapp20.adapters;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vendingapp20.R;
import com.example.vendingapp20.models.VendingMachineCoin;
import com.example.vendingapp20.models.VendingMachineDrink;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class VendingCoinAdapter extends RecyclerView.Adapter<VendingCoinAdapter.ViewHolder>{

    private Context mContext;

    private List<VendingMachineCoin> coins;

    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    private ItemClickListener itemClickListener;

    public VendingCoinAdapter(Context mContext, List<VendingMachineCoin> coins) {
        this.mContext = mContext;
        this.coins = coins;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VendingCoinAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.vending_coin_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VendingMachineCoin current = coins.get(position);
        holder.txtCoinValue.setText(String.valueOf(current.getCoinValue()));
        if (itemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedItems!=null){
                        if (selectedItems.get(holder.getAdapterPosition(),false)){
                            selectedItems.delete(holder.getAdapterPosition());
                            v.setSelected(false);
                        }
                        else{
                            selectedItems.put(holder.getAdapterPosition(),true);
                            v.setSelected(true);
                        }
                    }
                    itemClickListener.onClick(current);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private MaterialTextView txtCoinValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCoinValue = itemView.findViewById(R.id.text_view_coin_value);
        }
    }

    public interface ItemClickListener{
        void onClick(VendingMachineCoin vendingMachineCoin);
    }

}
