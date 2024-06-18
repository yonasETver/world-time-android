package com.yonastedela63.worldtime.world.time;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WorldTime {
    public static String location;
    public static String flag;
    public static String url;
    public static String time = "12: 98";
    public static Boolean isDayTime = false;

    public WorldTime(String location, String flag, String url) {
        this.location = location;
        this.flag = flag;
        this.url = url;
    }

    private OnTimeFetchedListener onTimeFetchedListener;

    public void setOnTimeFetchedListener(OnTimeFetchedListener listener) {
        this.onTimeFetchedListener = listener;
    }

    public interface OnTimeFetchedListener {
        void onTimeFetched(String time, boolean isDayTime);
    }

    public void getTime() {
        new FetchTimeTask().execute("http://worldtimeapi.org/api/timezone/" + this.url);
    }


    private class FetchTimeTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String apiUrl = params[0];
            try {
                // Make an HTTP GET request
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Extract the time from the JSON object
                return jsonResponse.getString("datetime");

            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // Handle the result on the main thread
            if (result != null) {
                try {
                    // Parse the entire datetime string to obtain a Date object
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    Date date = inputFormat.parse(result);

                    // Extract the hour from the Date object
                    SimpleDateFormat hourFormat = new SimpleDateFormat("HH", Locale.US);
                    String hour = hourFormat.format(date);

                    WorldTime.isDayTime = Integer.parseInt(hour) >= 6 && Integer.parseInt(hour) < 18;

                    // Create a SimpleDateFormat object for formatting the output time
                    SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.US);

                    // Format the Date object to get the time in 12-hour format with AM/PM
                    String outputTime = outputFormat.format(date);

                    // Print the converted
                    WorldTime.time = outputTime;
                    System.out.println("Converted time: " + WorldTime.time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (onTimeFetchedListener != null) {
                    onTimeFetchedListener.onTimeFetched(WorldTime.time, WorldTime.isDayTime);
                }
            } else {
                // Handle the error
                WorldTime.time = "Couldn't find time data; connect to the internet";
            }
        }
    }




}
