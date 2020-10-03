package com.example.ranul.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ranul.myapplication.DB.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    //login variables
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button sBtn, btnshare;
    EditText txt_name, txt_pass;
    Cursor cursor;                    //new class

    private static Button forgotButton;
    private static Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtonListner();

        //read values from the db
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();                   //read the db
        sBtn = (Button)findViewById(R.id.signButtn);
        txt_name = (EditText)findViewById(R.id.editSign);
        txt_pass = (EditText)findViewById(R.id.editPass);

        btnshare = findViewById(R.id.button3);

    }



    public void onClickButtonListner(){

        forgotButton = (Button)findViewById(R.id.forgotButton);
        forgotButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ForgotActivity.class);
                        startActivity(intent);
                    }
                }
        );

        sBtn = (Button)findViewById(R.id.signButtn);
        sBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String userName = txt_name.getText().toString();
                        String PasswD = txt_pass.getText().toString();
                        cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_2 + "= ? AND " + DatabaseHelper.COL_5 + " = ? ", new String[]{userName, PasswD});
                        if (cursor != null){
                            if (cursor.getCount()>0){
                                cursor.moveToNext();
                                Intent welcome_Intent = new Intent(MainActivity.this, Welcome.class);
                                startActivity(welcome_Intent);
                                Toast.makeText(getApplicationContext(), "SuccessFully Login", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(getApplicationContext(), "UserName or the Password Incorrect", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );

        register = (Button)findViewById(R.id.Regisbutton);
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }


}
