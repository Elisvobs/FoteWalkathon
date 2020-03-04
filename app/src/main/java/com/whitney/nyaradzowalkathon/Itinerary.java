package com.whitney.nyaradzowalkathon;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.whitney.nyaradzowalkathon.adapters.DaysAdapter;
import com.whitney.nyaradzowalkathon.fragments.DialogShowFriday;
import com.whitney.nyaradzowalkathon.fragments.DialogShowMonday;
import com.whitney.nyaradzowalkathon.fragments.DialogShowSaturday;
import com.whitney.nyaradzowalkathon.fragments.DialogShowSunday;
import com.whitney.nyaradzowalkathon.fragments.DialogShowThursday;
import com.whitney.nyaradzowalkathon.fragments.DialogShowTuesday;
import com.whitney.nyaradzowalkathon.fragments.DialogShowWednesday;
import com.whitney.nyaradzowalkathon.models.Days;

import java.util.ArrayList;

public class Itinerary extends AppCompatActivity {
    ListView listView1;
    GridView gridView;

    String[] days = {
            "Monday 26 November",
            "Tuesday 27 November",
            "Wednesday 28 November",
            "Thursday 29 November",
            "Friday 30 November",
            "Saturday 01 Secember",
            "Sunday 02 December"
    };
    String[] modayDinner = {
            "Sadza", "Rice", "Chicken", "Stew", "Fried Covo/Rape"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);

        listView1 = findViewById(R.id.list1);

        final ArrayList<Days> word = new ArrayList<Days>();

        word.add(new Days("Monday    26 November", R.drawable.food));
        word.add(new Days("Tuesday   27 November", R.drawable.food));
        word.add(new Days("Wednesday 28 November", R.drawable.food));
        word.add(new Days("Thursday  29 November", R.drawable.food));
        word.add(new Days("Friday    30 November", R.drawable.food));
        word.add(new Days("Saturday  01 Secember", R.drawable.food));
        word.add(new Days("Sunday    02 December", R.drawable.food));

        DaysAdapter day = new DaysAdapter(this, word, R.color.colorPrimary);
        final ListView listView = findViewById(R.id.list1);
        listView.setAdapter(day);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Days sound = word.get(position);
                int itemPosition = position;
                if (itemPosition == 0) {
                    showMonday();

                } else if (itemPosition == 1) {
                    showTuesday();
                } else if (itemPosition == 2) {
                    showWednesday();
                } else if (itemPosition == 3) {
                    showThursday();
                } else if (itemPosition == 4) {
                    showFriday();
                } else if (itemPosition == 5) {
                    showSaturday();
                } else if (itemPosition == 6) {
                    showSunday();
                }
            }
        });
    }

    private void showTuesday() {
        DialogShowTuesday dialog = new DialogShowTuesday();
        dialog.show(getFragmentManager(), "");
    }

    private void showMonday() {
        DialogShowMonday dialog = new DialogShowMonday();
        dialog.show(getFragmentManager(), "");
    }

    private void showWednesday() {
        DialogShowWednesday dialog = new DialogShowWednesday();
        dialog.show(getFragmentManager(), "");
    }

    private void showThursday() {
        DialogShowThursday dialog = new DialogShowThursday();
        dialog.show(getFragmentManager(), "");
    }

    private void showFriday() {
        DialogShowFriday dialog = new DialogShowFriday();
        dialog.show(getFragmentManager(), "");
    }

    private void showSaturday() {
        DialogShowSaturday dialog = new DialogShowSaturday();
        dialog.show(getFragmentManager(), "");
    }

    private void showSunday() {
        DialogShowSunday dialog = new DialogShowSunday();
        dialog.show(getFragmentManager(), "");
    }
}