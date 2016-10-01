package poojab26.travelstyle.Views;

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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import poojab26.travelstyle.Models.Classifier.Class;
import poojab26.travelstyle.Models.Classifier.Example;
import poojab26.travelstyle.R;

/**
 * Created by pblead26 on 30-Sep-16.
 */
public class ClassifyImage extends AppCompatActivity {

    EditText emailText;
    TextView responseView;
    ProgressBar progressBar;
    String email;
    static final String API_KEY = "43fd976fab75fbc6909ddc9eb4a3a2cb38f6d74f";
    static final String API_URL = "https://watson-api-explorer.mybluemix.net/visual-recognition/api/v3/classify?";
    static final String ibm_version = "2016-05-20";
    static final String Classifer_ID = "clothes_607342350";

    String URL = "http://riverisland.scene7.com/is/image/RiverIsland/408680_main?$CrossSellProductPage300$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_image);

        responseView = (TextView) findViewById(R.id.responseView);
        emailText = (EditText) findViewById(R.id.emailText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button queryButton = (Button) findViewById(R.id.queryButton);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailText.getText().toString();
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
                URL url = new URL(API_URL + "api_key=" + API_KEY + "&url=" + URL + "&classifier_ids=" + Classifer_ID + "&version=" + ibm_version);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
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
                response = "THERE WAS AN ERROR";
            }
            progressBar.setVisibility(View.GONE);
            Log.i("INFO", response);
            responseView.setText(response);

            // TODO: check this.exception
            // TODO: do something with the feed

           try {

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
            }
        }
    }
}