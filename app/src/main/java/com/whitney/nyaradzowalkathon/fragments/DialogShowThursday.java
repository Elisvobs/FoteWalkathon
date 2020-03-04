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

public class DialogShowThursday extends DialogFragment {

    String[] items1 = {
            "Cereals",
            "Fried Eggs", "Baked Beans", "Polony Assorted", "Bread", "Margarine", "Peanut Butter", "Marmalade", "Jam",
            "Sun Jam",
            "Tea or Coffee"
    };
    String[] items2 = {
            "Beef Cubes with Boiled Potatoes",
            "Tossed  Shelled Peas & Carrots",
            "Orange"
    };
    String[] items3 = {
            "Chicken Stew",
            "Sadza", "Rice",
            "Fried Cabbages with Carrots",
            "Tomato and Onion Sauce"
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.thursday, null);

        GridView breakfast = dialogView.findViewById(R.id.grid7);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, items1);
        breakfast.setAdapter(adapter);

        GridView lunch = dialogView.findViewById(R.id.grid8);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, items2);
        lunch.setAdapter(adapter2);

        GridView supper = dialogView.findViewById(R.id.grid9);
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