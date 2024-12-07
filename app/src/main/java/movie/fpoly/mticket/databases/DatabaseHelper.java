package movie.fpoly.mticket.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="MTICKET.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USERS = "CREATE TABLE USERS (" +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "phone TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE_USERS);

        String CREATE_TABLE_MOVIES = "CREATE TABLE MOVIES (" +
                "movie_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category_id INTEGER NOT NULL, " +
                "movie_name TEXT NOT NULL, " +
                "movie_trailer TEXT NOT NULL, " +
                "movie_description TEXT NOT NULL, " +
                "movie_release DATE NOT NULL, " +
                "movie_poster TEXT NOT NULL, " +
                "movie_length TEXT NOT NULL)" ;
        db.execSQL(CREATE_TABLE_MOVIES);

        String CREATE_TABLE_SEATS = "CREATE TABLE SEATS (" +
                "seat_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "seat_type INTEGER NOT NULL, " +
                "room_id INTEGER REFERENCES ROOM(room_id), " +
                "row_seat TEXT NOT NULL, " +
                "number INTEGER NOT NULL)";
        db.execSQL(CREATE_TABLE_SEATS);

        String CREATE_TABLE_SCHEDULE = "CREATE TABLE SCHEDULE (" +
                "schedule_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "movie_id INTEGER REFERENCES MOVIES(movie_id), " +
                "room_id INTEGER REFERENCES ROOM(room_id), " +
                "schedule_date DATE NOT NULL)";
        db.execSQL(CREATE_TABLE_SCHEDULE);

        String CREATE_TABLE_ROOM = "CREATE TABLE ROOM (" +
                "room_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cinema_id INTEGER REFERENCES CINEMAS(cinema_id), " +
                "room_name TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE_ROOM);

        String CREATE_TABLE_CINEMAS = "CREATE TABLE CINEMAS (" +
                "cinema_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cinema_name TEXT NOT NULL, " +
                "cinema_address TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE_CINEMAS);

        String CREATE_TABLE_CATEGORIES = "CREATE TABLE CATEGORIES (" +
                "category_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "category_name TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE_CATEGORIES);

        String CREATE_TABLE_BOOKING = "CREATE TABLE BOOKING (" +
                "booking_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id INTEGER REFERENCES USERS(user_id), " +
                "schedule_id INTEGER REFERENCES SCHEDULE(schedule_id), " +
                "seat_id INTEGER REFERENCES SEATS(seat_id), " +
                "price DOUBLE NOT NULL, " +
                "seat_status INTEGER NOT NULL)";
        db.execSQL(CREATE_TABLE_BOOKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        db.execSQL("DROP TABLE IF EXISTS MOVIES");
        db.execSQL("DROP TABLE IF EXISTS SEATS");
        db.execSQL("DROP TABLE IF EXISTS SCHEDULE");
        db.execSQL("DROP TABLE IF EXISTS ROOM");
        db.execSQL("DROP TABLE IF EXISTS CINEMAS");
        db.execSQL("DROP TABLE IF EXISTS CATEGORIES");
        db.execSQL("DROP TABLE IF EXISTS BOOKING");
        onCreate(db);
    }
}
