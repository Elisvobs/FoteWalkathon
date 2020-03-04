package com.whitney.nyaradzowalkathon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class GridAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private String[] result;
    private Context context;
    private int[] imageId;

    public GridAdapter(Home mainActivity, String[] osNameList, int[] osImages) {
        result = osNameList;
        context = mainActivity;
        imageId = osImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.custom_grid, null);
        holder.os_text = rowView.findViewById(R.id.text1);
        holder.os_img = rowView.findViewById(R.id.image1);

        holder.os_text.setText(result[position]);
        holder.os_img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (position == 0) {
                    context.startActivity(new Intent(context, MainActivity.class));
                } else if (position == 1) {
                    context.startActivity(new Intent(context, Website.class));
                } else if (position == 2) {
                    context.startActivity(new Intent(context, Gallery.class));
                } else if (position == 3) {
                    context.startActivity(new Intent(context, Instructions.class));
                } else if (position == 4) {
                    context.startActivity(new Intent(context, Trees.class));
                } else if (position == 5) {
                    // Creates an Intent that will load a map of Harare
                    try {
                        Uri gmmIntentUri = Uri.parse("geo:-17.8252,31.0335");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        context.startActivity(mapIntent);
                    } catch (Exception e) {
                        Toast.makeText(context, "No Maps App in your Phone", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return rowView;
    }

    public class Holder {
        TextView os_text;
        ImageView os_img;
    }
}