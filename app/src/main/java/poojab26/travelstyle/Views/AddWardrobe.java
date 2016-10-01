package poojab26.travelstyle.Views;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import poojab26.travelstyle.Database.WardrobeContentProvider;
import poojab26.travelstyle.Database.WardrobeDb;
import poojab26.travelstyle.Models.Classifier.Class;
import poojab26.travelstyle.Models.Classifier.Example;
import poojab26.travelstyle.R;
import poojab26.travelstyle.RealPathUtil;
import poojab26.travelstyle.Watson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pblead26 on 30-Sep-16.
 */
public class AddWardrobe extends AppCompatActivity {
    private int PICK_IMAGE_REQUEST = 1;
    String TAG = "TAG";
    public static final String BASE_URL = "https://watson-api-explorer.mybluemix.net/visual-recognition/api/v3/classify/";
    private String id;
    String res, finalJSON;
    String LOGTAG = "AddWardrobe";
    String URL;
    int PART[] = {1,2,3,4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe);

        Button addWardrobe = (Button) findViewById(R.id.add_wardrobe);
        addWardrobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            Log.d(TAG, "onActivityResult:THE IMAGE PATH IS " + RealPathUtil.getRealPathFromURI_API19(this, data.getData())
            );
            URL = RealPathUtil.getRealPathFromURI_API19(this, data.getData());

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);

                Log.d(TAG, "onActivityResult: TRYING TO START UPLOAD");


                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        //.client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                File file = new File(RealPathUtil.getRealPathFromURI_API19(this, data.getData()));
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("images_file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));

                Watson apiService = retrofit.create(Watson.class);
                Call<Example> call = apiService.classify(filePart);
                call.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if(response.code()==200){

                            Example c = response.body();
                            int size = c.getImages().get(0).getClassifiers().get(0).getClasses().size();
                            List<Class> classes = c.getImages().get(0).getClassifiers().get(0).getClasses();
                            Log.i("TEST", String.valueOf(size));
                            int part = getBodyPart(classes, size);

                            evaluate(classes, part);

                        }
                        if(response.code()==400){
                            Log.i("BAD", "BAD");
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void evaluate(List<Class> scoreList, int part){


        Log.d(LOGTAG, "inside database");

        for (int i=0; i<scoreList.size(); i++) {
            Log.d(LOGTAG, "ITERATION");
            // Add a new group record
            ContentValues values = new ContentValues();

            values.put(WardrobeDb.KEY_URL,
                    (URL));
            values.put(WardrobeDb.KEY_NAME,
                    (scoreList.get(i).getClass_()));
            values.put(WardrobeDb.KEY_PART,
                    (part));
            values.put(WardrobeDb.KEY_WARMTH,
                    (1));

            Uri uri = getContentResolver().insert(
                    WardrobeContentProvider.CONTENT_URI, values);

            Log.d(LOGTAG, uri.toString());
        }
        Log.d(LOGTAG, "database done");

    }

    private int getBodyPart(List<Class> items, int size){
        int part_index =0;

        for(int i=0; i<size; i++)
            if((items.get(i).getClass_()).equals("boots") ||(items.get(i).getClass_()).equals("flipflops")
                    || (items.get(i).getClass_()).equals("sneakers") ){
                part_index = 4;
            }

            else if((items.get(i).getClass_()).equals("jeans") ||(items.get(i).getClass_()).equals("shorts")
                    || (items.get(i).getClass_()).equals("skirts") || (items.get(i).getClass_()).equals("trousers") ){
                part_index = 3;
            }

            else if((items.get(i).getClass_()).equals("jeansjacket") ||(items.get(i).getClass_()).equals("summerdress")
                    || (items.get(i).getClass_()).equals("sweaters") || (items.get(i).getClass_()).equals("trousers") ){
                part_index = 2;
            }

            else if((items.get(i).getClass_()).equals("hat")){
                part_index = 1;
            }
        return part_index;
    }


    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}