package poojab26.travelstyle.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import poojab26.travelstyle.Models.Geocode.Geocode;
import poojab26.travelstyle.R;

/**
 * Created by pblead26 on 30-Sep-16.
 */
public class RetrieveGeocode extends AppCompatActivity {

    EditText destinationText;
    TextView responseView;
    ProgressBar progressBar;
    String dest;
    static final String API_KEY = "AIzaSyBPWC6k0txcFQ-OwNzp-fOuGwB8vGymwbE";
    static final String API_URL = "https://maps.googleapis.com/maps/api/geocode/json?";
    String address = "San Francisco";
    String temp = "San Francisco";
    String query;
    String GEOCODE_PREFS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_geocode);

        responseView = (TextView) findViewById(R.id.geocode);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        destinationText = (EditText) findViewById(R.id.user_destination);

        Button queryButton = (Button) findViewById(R.id.queryButton);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest = destinationText.getText().toString();
                try {
                    query = URLEncoder.encode(dest, "utf-8");
                    }
                catch(UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                new RetrieveFeedTask().execute();

            }
        });
    }

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
        }

        protected String doInBackground(Void... urls) {
            // Do some validation here

            try {
                URL url = new URL(API_URL + "address=" + query + "&key=" + API_KEY);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    String response = stringBuilder.toString();
                    Log.i("GEOCODE INFO", response);


                        Gson gson = new Gson();
                        Geocode geo = gson.fromJson(response, Geocode.class);
                        String Lat = geo.getResults().get(0).getGeometry().getLocation().getLat().toString();
                        String Lng = geo.getResults().get(0).getGeometry().getLocation().getLng().toString();
                        String destination =  geo.getResults().get(0).getFormattedAddress().toString();

                        SharedPreferences.Editor editor = getSharedPreferences(GEOCODE_PREFS, MODE_PRIVATE).edit();
                        editor.putString("Lat", Lat);
                        editor.putString("Long", Lng);
                        editor.putString("Dest", destination);
                        editor.commit();
                        Log.i("GEO NULL", Lat + Lng);

                        Intent i = new Intent(RetrieveGeocode.this, WeatherForecast.class);
                        startActivity(i);

                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if(response == null) {
                responseView.setText("THERE WAS AN ERROR");
            }
            progressBar.setVisibility(View.GONE);

            // TODO: check this.exception
            // TODO: do something with the feed


        }
    }
}