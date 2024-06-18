package com.yonastedela63.worldtime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.yonastedela63.worldtime.pages.CountryList;
import com.yonastedela63.worldtime.pages.Loading;
import com.yonastedela63.worldtime.world.time.WorldTime;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        try {
            Intent intent = new Intent(MainActivity.this, Loading.class);
            intent.putExtra("location", "Addis Ababa");
            intent.putExtra("flag", "ethiopia");
            intent.putExtra("url","Africa/Addis_Ababa");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log, show a message)
        }
    }
}