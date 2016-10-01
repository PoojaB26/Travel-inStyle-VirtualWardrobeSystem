package poojab26.travelstyle.Views;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import poojab26.travelstyle.Models.Weather.Weather;
import poojab26.travelstyle.R;

/**
 * Created by pblead26 on 30-Sep-16.
 */
public class WeatherForecast extends AppCompatActivity {

    EditText emailText;
    TextView responseView;
    ProgressBar progressBar;
    String email;
    static final String API_KEY = "AIzaSyBPWC6k0txcFQ-OwNzp-fOuGwB8vGymwbE";
    static final String API_URL = "https://twcservice.au-syd.mybluemix.net/api/weather/v1/geocode/";
    String query;
    final String basicAuth = "Basic " + Base64.encodeToString("6a2db0f5-a1e9-4db5-b34d-9dd371354de9:93iiWLNGsI".getBytes(), Base64.NO_WRAP);
    String GEOCODE_PREFS;
    String Lat, Lng, Dest;
    int day_temp, eve_temp;
    int temp_index[] = {10, 23, 30, 50};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        responseView = (TextView) findViewById(R.id.geocode);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        SharedPreferences prefs = getSharedPreferences(GEOCODE_PREFS, MODE_PRIVATE);

            Lat = prefs.getString("Lat", "No name defined");//"No name defined" is the default value.
            Lng = prefs.getString("Long", "No name defined");//"No name defined" is the default value.
            Dest = prefs.getString("Dest", "No name defined");//"No name defined" is the default value.


        Log.i("NULL", Lat + "  " + Lng);
        new RetrieveWeather().execute();

    }

    class RetrieveWeather extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
        }

        protected String doInBackground(Void... urls) {
            // Do some validation here

            try {
                URL url = new URL(API_URL + Lat + "/" + Lng + "/forecast/intraday/10day.json?units=m");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty ("Authorization", basicAuth);

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    String response = stringBuilder.toString();
                    Log.i("WEATHER INFO", response);

                    Gson gson = new Gson();
                    Weather weather = gson.fromJson(response, Weather.class);
                    Integer size = weather.getForecasts().size();
                    Log.i("SIZE WEATHER", size.toString());

                    for(int j = size - 1; j >= size-4 ; j--) {
                        if((weather.getForecasts().get(j).getDaypartName().toString()).equals("Afternoon")){
                            Log.i("DAY", weather.getForecasts().get(j).getDaypartName().toString());

                            day_temp = weather.getForecasts().get(j).getTemp();
                            Log.i("DAY", String.valueOf(day_temp));

                        }

                       else if((weather.getForecasts().get(j).getDaypartName().toString()).equals("Evening")){
                            Log.i("EVE", weather.getForecasts().get(j).getDaypartName().toString());

                            eve_temp = weather.getForecasts().get(j).getTemp();
                            Log.i("EVE", String.valueOf(eve_temp));

                        }
                    }
                    checkTempRange();



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

        private void checkTempRange() {
            if(day_temp<=10)
                day_temp = temp_index[0];
            else if(day_temp>=11 && day_temp<=23)
                day_temp = temp_index[1];
            else if(day_temp>=24 && day_temp <= 30)
                day_temp = temp_index[2];
            else if(day_temp>=31 && day_temp <=100)
                day_temp=temp_index[3];




            if(eve_temp<=10)
                eve_temp = temp_index[0];
            else if(eve_temp>=11 && eve_temp<=23)
                eve_temp = temp_index[1];
            else if(eve_temp>=24 && eve_temp <= 30)
                eve_temp = temp_index[2];
            else if(eve_temp>31)
                eve_temp = temp_index[3];


            Log.i("TEMP", day_temp + " " + eve_temp);
        }

        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }
            progressBar.setVisibility(View.GONE);
            responseView.setText(response);

            // TODO: check this.exception
            // TODO: do something with the feed

         /*  try {

                Gson gson = new Gson();
                Example ex = gson.fromJson(response, Example.class);
                Integer size = ex.getImages().get(0).getClassifiers().get(0).getClasses().size();
               List<Class> classes = ex.getImages().get(0).getClassifiers().get(0).getClasses();

               Log.d("SIZE", size.toString());
               for (int i=0; i<size ; i++){
                   Log.d("ARRAY" + i, classes.get(i).getClass_() + " " + classes.get(i).getScore());

               }


           } catch (Exception e) {
                  e.printStackTrace();
            }*/
        }
    }
}