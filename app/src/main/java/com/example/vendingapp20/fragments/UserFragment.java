package com.example.vendingapp20.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vendingapp20.R;
import com.example.vendingapp20.adapters.VendingMachineDrinkAdapter;
import com.example.vendingapp20.models.VendingMachineDrink;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

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

    private RecyclerView drinkRecycler;
    private List<VendingMachineDrink> drinks;
    private VendingMachineDrinkAdapter drinkAdapter;
    private FirebaseFirestore db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        drinkRecycler = rootView.findViewById(R.id.recycler_view_drinkList);
        db = FirebaseFirestore.getInstance();
        drinkRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        drinks = new ArrayList<>();
        drinkAdapter = new VendingMachineDrinkAdapter(getContext(), drinks);
        drinkRecycler.setAdapter(drinkAdapter);
        getDrinks();


        return rootView;
    }

    private void getDrinks(){
        db.collection("VendingMachineDrink").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d : list){
                                VendingMachineDrink drink = d.toObject(VendingMachineDrink.class);
                                drinks.add(drink);
                            }
                            drinkAdapter.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(getContext(),"Данные не найдены!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}