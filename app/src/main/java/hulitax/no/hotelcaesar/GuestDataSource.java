package hulitax.no.hotelcaesar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by erlend on 28.05.17.
 */

public class GuestDataSource {

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String [] allColumns = { SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_FNAME, SQLiteHelper.COLUMN_LNAME, SQLiteHelper.COLUMN_CCNR};


    public GuestDataSource (Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close () {
        dbHelper.close();
    }

    public Guest createGuest(String fName, String lName, String ccnr) {
        ContentValues values = new ContentValues();
        Random ran = new Random();
        int mid = ran.nextInt(50)+1;
        values.put(SQLiteHelper.COLUMN_ID,mid);
        values.put(SQLiteHelper.COLUMN_FNAME,fName);
        values.put(SQLiteHelper.COLUMN_LNAME,lName);
        values.put(SQLiteHelper.COLUMN_CCNR,ccnr);
        long insertId = database.insert(SQLiteHelper.TABLE_GUEST,null,values);

        Cursor cursor = database.query(SQLiteHelper.TABLE_GUEST,allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId,null,null,null,null);
        cursor.moveToFirst();
        Guest newGuest = cursorToGuest(cursor);
        cursor.close();
        return newGuest;
    }

    private Guest cursorToGuest(Cursor cursor) {
        Guest guest = new Guest();
        guest.setmId(cursor.getInt(0));
        guest.setfName(cursor.getString(1));
        guest.setlName(cursor.getString(2));
        guest.setCcnr(cursor.getString(3));
        return guest;
    }

    public void deleteGuest() {
        Cursor cursor = database.query(SQLiteHelper.TABLE_GUEST,allColumns,null,null,null,null,null);

        cursor.moveToFirst();

        Guest guest = cursorToGuest(cursor);
        int mId = guest.getmId();
        database.delete(SQLiteHelper.TABLE_GUEST, SQLiteHelper.COLUMN_ID + "=" + mId, null);
    }

    public List<Guest> getAllGuest() {
        List<Guest> guests = new ArrayList<Guest>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_GUEST,allColumns,null,null,null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Guest guest = cursorToGuest(cursor);
            guests.add(guest);
            cursor.moveToNext();
        }

        cursor.close();
        return guests;
    }
}