package com.example.intern_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);
    }

    public void loginWithMobile(View view) {
        Intent categoryIntent =new Intent(this,LoginWithMobile.class);
        startActivity(categoryIntent);
    }


    public void continueWithEmail(View view) {
        Intent categoryIntent =new Intent(this,LoginWithMobile.class);
        startActivity(categoryIntent);

    }
}
