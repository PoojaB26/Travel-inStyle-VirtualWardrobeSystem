package poojab26.travelstyle.Database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by pblead26 on 01-Oct-16.
 */
public class DestinationDb{

    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String  KEY_TEMP_DAY = "temp_day";
    public static final String KEY_TEMP_EVE = "temp_eve";

    private static final String LOG_TAG = "DestinationDb";
    public static final String SQLITE_TABLE = "Destination";

    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                    KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                    KEY_NAME + "," +
                    KEY_TEMP_DAY + "," +
                    KEY_TEMP_EVE + "," +
                    " UNIQUE (" + KEY_ROWID +"));"; // TODO: 01-Oct-16  

    public static void onCreate(SQLiteDatabase db) {
        Log.w(LOG_TAG, DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(LOG_TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
        onCreate(db);
    }

}