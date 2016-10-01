package poojab26.travelstyle.Database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by pblead26 on 01-Oct-16.
 */
public class WardrobeDb {

        public static final String KEY_ROWID = "_id";
        public static final String KEY_URL = "url";
    public static final String KEY_NAME = "name";
    public static final String  KEY_WARMTH = "warmth";
        public static final String KEY_PART = "part";

        private static final String LOG_TAG = "WardrobeDb";
        public static final String SQLITE_TABLE = "Wardrobe";

        private static final String DATABASE_CREATE =
                "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                        KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                        KEY_URL + "," +
                        KEY_NAME + "," +
                        KEY_WARMTH + "," +
                        KEY_PART + ");";


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
