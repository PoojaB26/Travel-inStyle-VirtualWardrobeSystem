package poojab26.travelstyle.Views;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import poojab26.travelstyle.Database.WardrobeContentProvider;
import poojab26.travelstyle.Database.WardrobeDb;
import poojab26.travelstyle.R;

/**
 * Created by pblead26 on 01-Oct-16.
 */
public class TestWardrobeEdit extends Activity implements View.OnClickListener {

    private Button save, delete;
    private String mode;
    private EditText url, name, warmth, covers;
    private String id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_wardrobe);

        // get the values passed to the activity from the calling activity
        // determine the mode - add, update or delete
        if (this.getIntent().getExtras() != null){
            Bundle bundle = this.getIntent().getExtras();
            mode = bundle.getString("mode");
        }

        // get references to the buttons and attach listeners
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);

        url = (EditText) findViewById(R.id.url);
        warmth = (EditText) findViewById(R.id.warmth);
        covers = (EditText) findViewById(R.id.covers);


        // if in add mode disable the delete option
        if(mode.trim().equalsIgnoreCase("add")){
            delete.setEnabled(false);
        }
        // get the rowId for the specific country
        else{
            Bundle bundle = this.getIntent().getExtras();
            id = bundle.getString("rowId");
            loadContactInfo();
        }

    }

    public void onClick(View v) {

        // get values from the spinner and the input text fields
        String myURL = url.getText().toString();
        String wIndex = warmth.getText().toString();
        String wCovers = covers.getText().toString();


        switch (v.getId()) {
            case R.id.save:
                ContentValues values = new ContentValues();
                values.put(WardrobeDb.KEY_URL, myURL);
                values.put(WardrobeDb.KEY_NAME, "name");
                values.put(WardrobeDb.KEY_WARMTH, wIndex);
                values.put(WardrobeDb.KEY_PART, wCovers);

                // insert a record
                if(mode.trim().equalsIgnoreCase("add")){
                    getContentResolver().insert(WardrobeContentProvider.CONTENT_URI, values);
                }
                // update a record
                else {
                    Uri uri = Uri.parse(WardrobeContentProvider.CONTENT_URI + "/" + id);
                    getContentResolver().update(uri, values, null, null);
                }
                finish();
                break;

            case R.id.delete:
                // delete a record
                Uri uri = Uri.parse(WardrobeContentProvider.CONTENT_URI + "/" + id);
                getContentResolver().delete(uri, null, null);
                finish();
                break;

            // More buttons go here (if any) ...

        }
    }

    // based on the rowId get all information from the Content Provider
    // about that country
    private void loadContactInfo(){

        String[] projection = {
                WardrobeDb.KEY_ROWID,
                WardrobeDb.KEY_URL,
                WardrobeDb.KEY_NAME,
                WardrobeDb.KEY_WARMTH,
                WardrobeDb.KEY_PART,

        };
        Uri uri = Uri.parse(WardrobeContentProvider.CONTENT_URI + "/" + id);
        Cursor cursor = getContentResolver().query(uri, projection, null, null,
                null);
        if (cursor != null) {
            cursor.moveToFirst();
            String wURL = cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_URL));
            String wName = cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_NAME));
            String wIndex = cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_WARMTH));
            String wCovers = cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_PART));

            url.setText(wURL);
            name.setText(wName);
            warmth.setText(wIndex);
            covers.setText(wCovers);

        }


    }

    // this sets the spinner selection based on the value
    private int getIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }
        }
        return index;
    }

}
