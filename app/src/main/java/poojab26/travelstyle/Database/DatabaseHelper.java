package poojab26.travelstyle.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pblead26 on 01-Oct-16.
 */
public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TravelStyle";
    private static final int DATABASE_VERSION = 1;

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        WardrobeDb.onCreate(db);
        DestinationDb.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        WardrobeDb.onUpgrade(db, oldVersion, newVersion);
        DestinationDb.onUpgrade(db, oldVersion, newVersion);

    }
}

