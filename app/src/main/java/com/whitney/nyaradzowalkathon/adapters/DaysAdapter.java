package com.whitney.nyaradzowalkathon.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.whitney.nyaradzowalkathon.R;
import com.whitney.nyaradzowalkathon.models.Days;

import java.util.ArrayList;

public class DaysAdapter extends ArrayAdapter<Days> {
    private static final String LOG_TAG = DaysAdapter.class.getSimpleName();
    private int mColorResourceId;

    public DaysAdapter(Activity context, ArrayList<Days> word, int colorResourceId) {
        super(context, 0, word);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }
        Days currentDay = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView date = listItemView.findViewById(R.id.date);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        date.setText(currentDay.getDate());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView image = listItemView.findViewById(R.id.image);
        if (currentDay.hasImage()) {
            image.setImageResource(currentDay.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }

        View linear = listItemView.findViewById(R.id.linear);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        linear.setBackgroundColor(color);

        return listItemView;
    }
}