package com.example.intern_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginNow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_now);
    }

    public void continueWithMobile(View view) {
        Intent categoryIntent =new Intent(this,LoginWithMobile.class);
        startActivity(categoryIntent);

    }
}
