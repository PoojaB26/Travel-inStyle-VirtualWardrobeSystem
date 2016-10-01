package poojab26.travelstyle.Views;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import poojab26.travelstyle.Database.WardrobeContentProvider;
import poojab26.travelstyle.Database.WardrobeDb;
import poojab26.travelstyle.R;

/**
 * Created by pblead26 on 01-Oct-16.
 */
public class DisplayWardrobe extends AppCompatActivity
        implements
        LoaderManager.LoaderCallbacks<Cursor>{


    private SimpleCursorAdapter dataAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_wardrobe);

        displayListView();


    }

    @Override
    protected void onResume() {
        super.onResume();
        //Starts a new or restarts an existing Loader in this manager
        getLoaderManager().restartLoader(0, null, this);
    }
    private void displayListView() {


        // The desired columns to be bound
        String[] columns = new String[] {
                WardrobeDb.KEY_URL,
                WardrobeDb.KEY_WARMTH,
                WardrobeDb.KEY_PART,


        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.text,
        };

        // create an adapter from the SimpleCursorAdapter
        dataAdapter = new SimpleCursorAdapter(
                this,
                R.layout.wardrobe_item,
                null,
                columns,
                to,
                0);

        // get reference to the ListView
        ListView listView = (ListView) findViewById(R.id.lv);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);
        //Ensures a loader is initialized and active.
        getLoaderManager().initLoader(0, null, this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // display the selected contact
                String contactNumber =
                        cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_WARMTH));
                Toast.makeText(getApplicationContext(),
                        contactNumber, Toast.LENGTH_SHORT).show();

                String rowId =
                        cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_ROWID));



            }
        });

    }

    // This is called when a new Loader needs to be created.
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                WardrobeDb.KEY_URL,
                WardrobeDb.KEY_WARMTH,
                WardrobeDb.KEY_PART,};
                CursorLoader cursorLoader = new CursorLoader(this,
                WardrobeContentProvider.CONTENT_URI, projection, null, null, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Swap the new cursor in.  (The framework will take care of closing the
        // old cursor once we return.)
        dataAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // This is called when the last Cursor provided to onLoadFinished()
        // above is about to be closed.  We need to make sure we are no
        // longer using it.
        dataAdapter.swapCursor(null);
    }


}
