package com.yonastedela63.worldtime.pages;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.yonastedela63.worldtime.R;

public class Home extends AppCompatActivity {

    private MaterialButton selectCountry;
    private Intent intent;
    private ImageView flag;
    private TextView country, localTime;
    private RelativeLayout upperWrapper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        // Check if a key exists before adding its value
        int bgColor;
        if (!sharedPref.contains("bg_color")) {
            editor.putInt("bg_color", ContextCompat.getColor(this, R.color.cyan));
            editor.apply();
            int defaultColorGreen = ContextCompat.getColor(this, R.color.cyan);
            bgColor = sharedPref.getInt("bg_color", defaultColorGreen);
        }else{
            int defaultColorGreen = ContextCompat.getColor(this, R.color.cyan);
            bgColor = sharedPref.getInt("bg_color", defaultColorGreen);
        }

        upperWrapper = findViewById(R.id.upperWrapper);
        selectCountry = findViewById(R.id.selectCountry);
        flag = findViewById(R.id.flag);
        country = findViewById(R.id.country);
        localTime = findViewById(R.id.localTime);

        selectCountry.setBackgroundColor(bgColor);
        country.setTextColor(bgColor);
        localTime.setTextColor(bgColor);

        ActionBar actionBar = getSupportActionBar();

        // Find your SeekBar by its ID
        intent = getIntent();
        String location = intent.getStringExtra("location");
        String flag2 = intent.getStringExtra("flag");
        String time = intent.getStringExtra("time");
        String isDayTime = intent.getStringExtra("isDayTime");
        //System.out.println("isDayTime.........:  "+ time.substring(6,8));

        if(time.substring(6,8).equals("AM") && Integer.parseInt(time.substring(0,2)) < 7 || time.substring(6,8).equals("PM") && Integer.parseInt(time.substring(0,2)) >=6){
            upperWrapper.setBackgroundResource(R.drawable.night);
            if (actionBar != null) {
                actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dark)));
            }
            // Change the status bar color
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.dark));
            }
        }else{
            upperWrapper.setBackgroundResource(R.drawable.day);
            if (actionBar != null) {
                actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skyBlue)));
            }
            // Change the status bar color
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.skyBlue));
            }
        }

        int resourceId = getResources().getIdentifier(flag2, "drawable", getPackageName());
        //Log.d("HomeActivity", "Resource ID: " + resourceId);
        if (resourceId != 0) {
            flag.setImageResource(resourceId);
            //Log.d("HomeActivity", "Image set successfully");
        } else {
            //Log.e("HomeActivity", "Resource not found: " + flag2);
            // Handle the case where the resource is not found
        }

        country.setText(location);
        localTime.setText(time);

        selectCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this, LocationRecycler.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();


        if (itemId == R.id.action_menu_orange) {
            //Toast.makeText(this, "Orange", Toast.LENGTH_SHORT).show();
            changeColor(R.color.orange);
            return true;
        }else if(itemId == R.id.action_menu_green){
            changeColor(R.color.green);
            return true;
        }else if(itemId == R.id.action_menu_cyan){
            changeColor(R.color.cyan);
            return true;
        }else if(itemId == R.id.action_menu_pink){
            changeColor(R.color.pink);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeColor(int colorResId){
        int color = ContextCompat.getColor(this, colorResId);
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("bg_color", ContextCompat.getColor(this, colorResId));
        editor.apply();
        selectCountry.setBackgroundColor(color);
        country.setTextColor(color);
        localTime.setTextColor(color);
    }
}
