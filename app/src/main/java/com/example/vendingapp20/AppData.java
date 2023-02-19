package com.example.vendingapp20;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;

public class AppData {

    public static void showToast(Context context, String message){
        View toastView = LayoutInflater.from(context).inflate(R.layout.toast_item,null,false);
        MaterialTextView txtToastText = toastView.findViewById(R.id.text_view_toastText);
        txtToastText.setText(message);
        Toast toast = new Toast(context);
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,150);
        toast.show();
    }

}
