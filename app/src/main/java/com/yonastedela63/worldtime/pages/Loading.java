package com.yonastedela63.worldtime.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.yonastedela63.worldtime.R;
import com.yonastedela63.worldtime.world.time.WorldTime;

import java.util.Timer;
import java.util.TimerTask;

public class Loading extends AppCompatActivity {

    private AnimationDrawable animation;
    private ImageView progImg;
    private Intent intent;
    String time2;
    Boolean isDayTime2;
    public static int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        count++;

        progImg = findViewById(R.id.progImg);
        animation = (AnimationDrawable) progImg.getDrawable();
        animation.start();

        double delay = 2;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                animation.stop();
                timer.cancel();


                intent = getIntent();
                String location = intent.getStringExtra("location");
                String flag = intent.getStringExtra("flag");
                String url = intent.getStringExtra("url");


                // Fetch time asynchronously
                WorldTime w1 = new WorldTime(location, flag, url);
                w1.setOnTimeFetchedListener(new WorldTime.OnTimeFetchedListener() {
                    @Override
                    public void onTimeFetched(String time, boolean isDayTime) {
                        // This callback is triggered when the time is fetched
                        time2 = time;
                        isDayTime2 = isDayTime;

                        // Now you can access the fetched data and start the new activity
                        String location = WorldTime.location;
                        String flag = WorldTime.flag;
                        intent = new Intent(Loading.this, Home.class);
                        intent.putExtra("location", location);
                        intent.putExtra("flag", flag);
                        intent.putExtra("time", time2);
                        intent.putExtra("isDayTime", isDayTime2);
                        startActivity(intent);
                    }
                });
                w1.getTime();
            }
        }, (long) (count == 1? (delay * 1000): (delay*0)));
    }
}