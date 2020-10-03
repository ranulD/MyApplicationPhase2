package com.example.ranul.myapplication.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * * Created by Ranul on 8/27/2019.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //HideKeyboard
    private Context context;



    //insert
    public static final String DATABASE_NAME = "WallApp.db";
    public static final String TABLE_NAME = "Register_table";
    public static final String COL_1 = "Id";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "EMail";
    public static final String COL_4 = "Mobile";
    public static final String COL_5 = "Password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        //create the db and table for testing
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE Table " + TABLE_NAME + "(Id INTEGER Primary Key Autoincrement, Name Text," +
                " EMail Text, Mobile INTEGER, Password Text )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    //hideKeyboard
    /*public void hideKeyboardFrom(View view){
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    */


    //insert Data
    public boolean insertData(String name, String email, String mobile, String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, mobile);
        contentValues.put(COL_5, password);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result== -1)
            return false;
        else
            return true;
    }
}
