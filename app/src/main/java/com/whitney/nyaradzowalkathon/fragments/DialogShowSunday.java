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

public class DialogShowSunday extends DialogFragment {

    String[] items = {
            "Cereals", "Packed Breakfast (Juice, Fruit, Scone, Boiled Eggs – 2, Crisps)"
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.sunday, null);

        GridView gridView = dialogView.findViewById(R.id.grid);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, items);
        gridView.setAdapter(adapter);


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