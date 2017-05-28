package hulitax.no.hotelcaesar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erlend on 28.05.17.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_GUEST = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FNAME = "firstname";
    public static final String COLUMN_LNAME = "lastname";
    public static final String COLUMN_CCNR = "creditcardnumber";


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "guests1.db";

    private static final String DATABASE_CREATE = "create table "
            +TABLE_GUEST + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_FNAME
            + " text not null, " + COLUMN_LNAME + " text not null," + COLUMN_CCNR + " text not null)";

    public SQLiteHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println(SQLiteHelper.class.getName().toString() + "Upgrading method");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GUEST);
        onCreate(db);
    }
}
