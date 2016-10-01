package poojab26.travelstyle.Views;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import poojab26.travelstyle.Database.WardrobeContentProvider;
import poojab26.travelstyle.Database.WardrobeDb;
import poojab26.travelstyle.R;

/**
 * Created by pblead26 on 01-Oct-16.
 */
public class TestWardrobeMainActivity extends Activity implements
        LoaderManager.LoaderCallbacks<Cursor>{

    private SimpleCursorAdapter dataAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_wardrobe);

        displayListView();

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // starts a new Intent to add a Country
                Intent contactEdit = new Intent(getBaseContext(), TestWardrobeEdit.class);
                Bundle bundle = new Bundle();
                bundle.putString("mode", "add");
                contactEdit.putExtras(bundle);
                startActivity(contactEdit);
            }
        });

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
                WardrobeDb.KEY_NAME,
                WardrobeDb.KEY_WARMTH,
                WardrobeDb.KEY_PART,
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.tvurl,
                R.id.tvName,
                R.id.tvWarmth,
                R.id.tvCovers,
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
        ListView listView = (ListView) findViewById(R.id.wardrobeList);
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
                String wardrobe_URL =
                        cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_URL));
                Toast.makeText(getApplicationContext(),
                        wardrobe_URL, Toast.LENGTH_SHORT).show();

                String rowId =
                        cursor.getString(cursor.getColumnIndexOrThrow(WardrobeDb.KEY_ROWID));

                // starts a new Intent to update/delete a Country
                // pass in row Id to create the Content URI for a single row
                Intent contactEdit = new Intent(getBaseContext(), TestWardrobeEdit.class);
                Bundle bundle = new Bundle();
                bundle.putString("mode", "update");
                bundle.putString("rowId", rowId);
                contactEdit.putExtras(bundle);
                startActivity(contactEdit);

            }
        });

    }

    // This is called when a new Loader needs to be created.
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                WardrobeDb.KEY_ROWID,
                WardrobeDb.KEY_URL,
                WardrobeDb.KEY_NAME,
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