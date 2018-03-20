package com.example.luisgarfias.project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void sendEmailWithResults(View view) {

    CheckBox emailCheckBox = (CheckBox) findViewById(R.id.email_results);
    boolean emailResults = emailCheckBox.isChecked();

}

}


