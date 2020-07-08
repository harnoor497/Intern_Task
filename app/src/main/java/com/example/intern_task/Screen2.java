package com.example.intern_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
    }

    public void loginScreen(View view) {
        Intent categoryIntent =new Intent(this,LoginNow.class);
        startActivity(categoryIntent);
    }
}
