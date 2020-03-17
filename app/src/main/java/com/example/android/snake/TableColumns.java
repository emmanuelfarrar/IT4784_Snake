package com.example.android.snake;

import android.provider.BaseColumns;

public final class TableColumns {

    //inner class that identifies the table columns
    public static final class Score implements BaseColumns {
        public static final String TABLE_NAME = "user_table";
        public static final String USERNAME = "username";
        public static final String SCORE = "score";
        public static final String DATE = "date";
    }
}
