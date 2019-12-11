package com.whitney.nyaradzowalkathon;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Trees extends AppCompatActivity {

    ListView listView;
    String[] trees = {"Mushumha   (Shona)",
            "Munjenje   (Tonga)",
            "Shuma      (Shona)",
            "Njenje     (Tonga)",
            "MuNkula    (Tonga)"

    };
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trees);

        listView = findViewById(R.id.tree);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Trees.this, android.R.layout.simple_list_item_1, android.R.id.text1, trees);
        listView.setAdapter(adapter);
    }
}