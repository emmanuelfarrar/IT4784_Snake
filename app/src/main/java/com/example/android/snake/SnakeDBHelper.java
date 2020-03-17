package com.example.android.snake;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class SnakeDBHelper extends SQLiteOpenHelper {

    //const and var
    private static final String TAG = "DB_OPERATION";
    private static final String DB_NAME = "user_table";
    private static final int DB_VERSION = 1;
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TableColumns.Score.TABLE_NAME
            + "(" + TableColumns.Score.USERNAME + "Text,"
            + TableColumns.Score.SCORE + "Text,"
            + TableColumns.Score.DATE + "Text);";


    //constructor
    public SnakeDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.e(TAG, "DATABASE CREATED/OPENED");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //execute the query
        db.execSQL(CREATE_USER_TABLE);
        Log.e(TAG, "Table was created");
    }

    //method to add userData to the table
    public void addUserData(String username, int score, String date) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableColumns.Score.USERNAME, username);
        contentValues.put(TableColumns.Score.SCORE, score);
        contentValues.put(TableColumns.Score.DATE, date);

        //insert into table and close table
        db.insert(TableColumns.Score.TABLE_NAME, null, contentValues);
        db.close();

        Log.e(TAG, "New row was inserted");
    }


    //checking if user exist
    public boolean checkIfUSerExist(String tblName, String colName, String colValue){
        SQLiteDatabase db = getWritableDatabase();

        try {
            Cursor cursor = db.rawQuery("SELECT " + colName+ " FROM " + tblName+ " WHERE "+colName
            + "='"+colValue+ "'", null);

            if (cursor.moveToFirst()) {
                db.close();
               // toastMessage("User is already registered!");
                Log.d("Record Already Exists", "Table is: "+tblName+ " Column Name: "
                +colName);

                return true;
            }
            Log.d("Record Created", "Table is:"+tblName+ " Column Name: "
                    +colName+ " Column Value:");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
            db.close();
        }
        return false;
    }


    //cursor method to retrieve user data
    public Cursor getInformation(SQLiteDatabase db) {
        Cursor cursor;                                  //used to get info from db
        //projection to chose the columns that the query will call
        String[] projections = {TableColumns.Score.TABLE_NAME, TableColumns.Score.SCORE, TableColumns.Score.DATE};
        String orderBy = TableColumns.Score.SCORE + "DESC";

        String maxCount = "5";

        //null represent clauses
        cursor = db.query(TableColumns.Score.TABLE_NAME, projections, null, null, null, null, orderBy, maxCount);

        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    /*
    //Toast method
    private void toastMessage(String message){
     Toast toast = Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
     */
}


