package movie.fpoly.mticket.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import movie.fpoly.mticket.databases.DatabaseHelper;
import movie.fpoly.mticket.models.Seats;

public class SeatDAO {
    private SQLiteDatabase db;

    public SeatDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        this.db = dbHelper.getReadableDatabase();
        this.db = dbHelper.getWritableDatabase();
    }

    public ArrayList<Seats> getSeats(String sql) {
        ArrayList<Seats> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Seats seats = new Seats();
                seats.setSeat_id(cursor.getInt(0));
                seats.setSeat_type(cursor.getInt(1));
                seats.setRoom_id(cursor.getInt(2));
                seats.setRow_seat(cursor.getString(3));
                seats.setNumber(cursor.getInt(4));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insertSeat (Seats seats) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seat_type", seats.getSeat_type());
        contentValues.put("room_id", seats.getRoom_id());
        contentValues.put("row_seat", seats.getRow_seat());
        contentValues.put("number", seats.getNumber());
        return db.insert("SEATS", null, contentValues);
    }

    public long updateSeat (Seats seats) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seat_type", seats.getSeat_type());
        contentValues.put("room_id", seats.getRoom_id());
        contentValues.put("row_seat", seats.getRow_seat());
        contentValues.put("number", seats.getNumber());
        return db.update("SEATS", contentValues, "seat_id = ?", new String[]{String.valueOf(seats.getSeat_id())});
    }

    public long deleteSeat (Seats seats) {
        return db.delete("SEATS", "seat_id = ?", new String[]{String.valueOf(seats.getSeat_id())});
    }
}
