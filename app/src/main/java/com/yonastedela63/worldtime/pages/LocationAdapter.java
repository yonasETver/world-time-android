package com.yonastedela63.worldtime.pages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.yonastedela63.worldtime.MainActivity;
import com.yonastedela63.worldtime.R;

import java.util.ArrayList;

public class LocationAdapter extends  RecyclerView.Adapter <LocationAdapter.ViewHolder> {

    private ArrayList <CountryList> countryLists = new ArrayList<>();
    private Context context;

    //constructor
    public LocationAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chose_location, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String flag = countryLists.get(position).getFlag();
        int resourceId = context.getResources().getIdentifier(flag, "drawable", context.getPackageName());
        Log.d("HomeActivity", "Resource ID: " + resourceId);
        if (resourceId != 0) {
            holder.flagImage.setImageResource(resourceId);
            Log.d("HomeActivity", "Image set successfully");
        } else {
            Log.e("HomeActivity", "Resource not found: " + flag);
            // Handle the case where the resource is not found
        }

        holder.cityName.setText(countryLists.get(position).getLocation());

        holder.linerWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Loading.class);
                intent.putExtra("location", countryLists.get(position).getLocation());
                intent.putExtra("flag", countryLists.get(position).getFlag());
                intent.putExtra("url",countryLists.get(position).getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryLists.size();
    }

    public void setCountryLists(ArrayList<CountryList> countryLists) {
        this.countryLists = countryLists;

        notifyDataSetChanged();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linerWrapper;
        private ShapeableImageView flagImage;
        private TextView cityName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linerWrapper = itemView.findViewById(R.id.linerWrapper);
            flagImage = itemView.findViewById(R.id.flagImage);
            cityName = itemView.findViewById(R.id.cityName);

        }
    }


}
