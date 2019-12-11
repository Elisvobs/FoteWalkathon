package com.whitney.nyaradzowalkathon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Instructions extends AppCompatActivity {

    ListView listView;

    //items to show
    String[] titles = {"DAY 1", "DAY 2", "DAY 3", "Day 4"};
    String[] insTitle = {"Executive lap - First 10km or to the breakfast point", "", "", "Executive lap - last 10km"};
    String[] ins1 = {"-> Breakfast 16.4km ; Open Space \n",
            "-> Breakfast - 14.3km; Simbala Secondary School \n",
            "-> Breakfast 18km ; Open Space at 94.3km peg \n",
            "-> Breakfast 17.3km; Siabuwa turn off \n"
    };

    String[] ins2 = {"-> Lunch 27km ; Ministry of Transport \n",
            "-> Lunch - 27.3km; Homestead at the 63.2km peg \n",
            "-> Lunch - 30.5km; at the quarry stones by the 106.8km peg \n",
            "-> Lunch 27.3km ; Open space by the 135km peg \n"
    };

    String[] ins3 = {
            "-> End of Day 36km; Eden General   Dealer",
            "-> End of day 40km; Kabila Bar (Close to Saba Primary School turn off)",
            "-> End of Day 41km; at the Open space by the 117.8km peg",
            "-> End of day 36 km; Binga Centre"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        CustomAdapter adapter = new CustomAdapter(Instructions.this, titles, insTitle, ins1, ins2, ins3);
        listView = findViewById(R.id.instructions);
        listView.setAdapter(adapter);
    }
}

class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] titles;
    private final String[] head;
    private final String[] morning;
    private final String[] afternoon;
    private final String[] evening;

    //constructor
    public CustomAdapter(Context context, String[] titles, String[] head, String[] morning, String[] afternoon, String[] evening) {
        super(context, R.layout.custom_list, titles);
        this.context = context;
        this.titles = titles;
        this.head = head;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list, null, false);

        TextView title = rowView.findViewById(R.id.text1);
        TextView hea = rowView.findViewById(R.id.text2);
        TextView morn = rowView.findViewById(R.id.text3);
        TextView aft = rowView.findViewById(R.id.text4);
        TextView eve = rowView.findViewById(R.id.text5);

        title.setText(titles[position]);
        hea.setText(head[position]);
        morn.setText(morning[position]);
        aft.setText(afternoon[position]);
        eve.setText(evening[position]);

        return rowView;
    }
}