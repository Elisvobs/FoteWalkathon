package com.whitney.nyaradzowalkathon.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.whitney.nyaradzowalkathon.R;

public class DialogShowWednesday extends DialogFragment {

    String[] items1 = {
            "Cereals with Milk",
            "Scrambled Eggs", "Baked Beans", "Breakfast Mince", "Bread", "Butter", "Peanut Margarine",
            "Marmalade Jam", "Sun Jam",
            "Tea or Coffee"
    };
    String[] items2 = {
            "Mixed Vegetables",
            "Pork Chop", "Chicken Roast", "Tumeric Rice", "Tomato and Onion Sauce",
            "Apple"
    };
    String[] items3 = {
            "Beef Stew", "Sadza", "Rice", "Curried Fried Cabbage",
            "Tomato and Onion Sauce"
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.wednesdy, null);

        GridView breakfast = dialogView.findViewById(R.id.grid4);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, items1);
        breakfast.setAdapter(adapter);

        GridView lunch = dialogView.findViewById(R.id.grid5);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, items2);
        lunch.setAdapter(adapter2);

        GridView supper = dialogView.findViewById(R.id.grid6);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, items3);
        supper.setAdapter(adapter3);

        Button btnOK = dialogView.findViewById(R.id.btnOK);

        builder.setView(dialogView);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }
}