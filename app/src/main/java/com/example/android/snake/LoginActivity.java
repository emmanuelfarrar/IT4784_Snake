package com.example.android.snake;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class LoginActivity extends Activity {

    //U03A1: creating objects
    SimpleDateFormat simpleDateFormat;
    EditText etUsername;
    TextView tvDate;
    Button btnStartGame, btnCreateUser;
    SnakeDBHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        //U03A1: instantiating objects
        btnCreateUser = (Button) findViewById(R.id.btnnewuser);
        btnStartGame = (Button) findViewById(R.id.btnstart);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                dbHelper.checkIfUSerExist("TABLE_NAME","USERNAME", username);


            }
        });

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
