package com.example.android.snake;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SnakeDBHelper extends SQLiteOpenHelper {

    //const and var
    private static final String TAG = "DB_OPERATION";
    private static final String DB_NAME = "USERDATA";
    private static final int DB_VERSION = 1;


    //constructor
    public SnakeDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.e(TAG, "DATABASE CREATED/OPENED");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlUserData = "CREATE TABLE user(username VARCHAR PRIMARY KEY, score int, date DATETIME);";

        //execute the query
        db.execSQL(sqlUserData);
        Log.e(TAG, "Table was created");
    }

    public void addUserData(String username, int score, String date) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("score", score);
        contentValues.put("date", date);

        //insert into table and close table
        db.insert("user", null, contentValues);
        db.close();

        Log.e(TAG, "New row was inserted");
    }

    public Cursor getInformation(SQLiteDatabase db) {
        Cursor cursor;                                  //used to get info from db
        String[] projections = {};
        // https://developer.android.com/training/secure-file-sharing/retrieve-info
        // https://developer.android.com/reference/android/database/Cursor
        // https://www.youtube.com/results?search_query=cursor+sqlite+android+studio

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
