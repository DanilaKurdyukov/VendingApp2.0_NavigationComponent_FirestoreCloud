package com.example.vendingapp20.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vendingapp20.AppData;
import com.example.vendingapp20.R;
import com.example.vendingapp20.adapters.VendingCoinAdapter;
import com.example.vendingapp20.adapters.VendingMachineDrinkAdapter;
import com.example.vendingapp20.models.VendingMachineCoin;
import com.example.vendingapp20.models.VendingMachineDrink;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public UserFragment() {

    }


    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FirebaseDatabase db;
    private DatabaseReference dbRef;


    private RecyclerView drinkRecycler,coinRecycler;

    private List<VendingMachineCoin> coins;

    private VendingCoinAdapter coinAdapter;
    private List<VendingMachineDrink> drinks;
    private VendingMachineDrinkAdapter drinkAdapter;

    int totalSum = 0;

    VendingMachineDrink selected;

    MaterialTextView txtTotalSum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        getDrinks();
        getCoins();
        drinkItemClick();
    }

    private void drinkItemClick(){
        drinkAdapter.setOnItemClickListener(new VendingMachineDrinkAdapter.ItemClickListener() {
            @Override
            public void onClick(VendingMachineDrink vendingMachineDrink) {
                selected = vendingMachineDrink;
                if(totalSum==0){
                    AppData.showToast(getContext(),"Перед покупкой необходимо внести деньги!");
                }
            }
        });
    }

    private void init(View rootView){
        db = FirebaseDatabase.getInstance();

        txtTotalSum = rootView.findViewById(R.id.text_view_totalSum);

        coinRecycler = rootView.findViewById(R.id.recycler_view_coinList);
        coinRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        coins = new ArrayList<>();
        coinAdapter = new VendingCoinAdapter(getContext(),coins);
        coinAdapter.setItemClickListener(new VendingCoinAdapter.ItemClickListener() {
            @Override
            public void onClick(VendingMachineCoin vendingMachineCoin) {

            }
        });
        coinRecycler.setAdapter(coinAdapter);

        drinkRecycler = rootView.findViewById(R.id.recycler_view_drinkList);
        drinkRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        drinks = new ArrayList<>();
        drinkAdapter = new VendingMachineDrinkAdapter(getContext(), drinks);

        drinkRecycler.setAdapter(drinkAdapter);
    }

    private void getCoins(){
        coins.clear();
        dbRef = db.getReference("Coins");
        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                coins.add(snapshot.getValue(VendingMachineCoin.class));
                coinAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                coinAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                coinAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                coinAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDrinks(){
        drinks.clear();
        dbRef = db.getReference("Drinks");
        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                drinks.add(snapshot.getValue(VendingMachineDrink.class));
                drinkAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                drinkAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                drinkAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                drinkAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}