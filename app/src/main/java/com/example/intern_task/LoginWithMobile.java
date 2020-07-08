package com.example.intern_task;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.intern_task.UsrSrvc;
import com.example.intern_task.ApiUtils;
import com.example.intern_task.ResObj;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;



public class LoginWithMobile extends AppCompatActivity {

    private EditText et_mobile, et_pwd;
    private TextView txt_mobile, txt_pwd;
    private Button btn_proceed;
    private RequestQueue mqueue;
//   UserService userService;

    UsrSrvc usrSrvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_mobile);

        et_mobile = (EditText) findViewById(R.id.editText);
        et_pwd = (EditText) findViewById(R.id.editText2);
        txt_mobile = (TextView) findViewById(R.id.txt_enter_mobile);
        txt_pwd = (TextView) findViewById(R.id.textView3);
        btn_proceed = (Button) findViewById(R.id.button5);

        Log.i ("hello created " , "#########################################################################");

        Toast.makeText (LoginWithMobile.this, "created", Toast.LENGTH_LONG).show ( );

    }

    public void proceedNow(View view) {
        String Mobile=et_mobile.getText().toString();
        String Pwd=et_pwd.getText().toString();
        new LoginUser().execute(Mobile,Pwd);
    }

    public class LoginUser extends AsyncTask<String,Void,String> {
        String toastResult=null;

        @Override
        protected String doInBackground(String... strings) {
            String Mobile =strings[0];
            String Pwd =strings[1];
            int toastResultInt=0;

            try {

                OkHttpClient okHttpClient = new OkHttpClient ( );
                RequestBody formBody = new FormBody.Builder ( )
                        .add ("user_id", Mobile)
                        .add ("user_pwd", Pwd)
                        .build ( );
                Log.i ("tag ", "######################################################################### inside try first ");

                Request request = new Request.Builder ( )
                        .url ("https://mekvahan.com/api/android_intern_task")
                        .post (formBody)
                        .build ( );
                Log.i ("tag  ", "######################################################################### inside try second ");

                Response response = null;
                try {
                    response = okHttpClient.newCall (request).execute ( );
                    Log.i ("tag  ", "######################################################################### outside if " + response.networkResponse ( ).code ( ));

                    if (response.isSuccessful ( )) {

                        final String result = response.body ( ).string ( );
                        Log.i ("tag  ", "######################################################################### inside if " + response.networkResponse ( ).code ( ));
                        Log.i ("msg  : ", result);
                        runOnUiThread (new Runnable ( ) {
                            public void run() {
                                Toast.makeText (LoginWithMobile.this, result, Toast.LENGTH_SHORT).show ( );
                            }
                        });

                        if (result.endsWith ("true}")) {
                            toastResult = "Booking Successful";
                            runOnUiThread (new Runnable ( ) {
                                public void run() {
                                    Toast.makeText (LoginWithMobile.this, "Booking Successful", Toast.LENGTH_SHORT).show ( );
                                }
                            });


                        } else {
                            toastResult = result;
                            runOnUiThread (new Runnable ( ) {
                                public void run() {
                                    Toast.makeText (LoginWithMobile.this, "Request can't process : " + result, Toast.LENGTH_SHORT).show ( );
                                }
                            });


                        }

                    } else {
                        toastResultInt = response.networkResponse ( ).code ( );
                        Log.i ("tag  ", "######################################################################### inside else Network response Code :" + response.networkResponse ( ).code ( ));
                        runOnUiThread (new Runnable ( ) {
                            public void run() {
                                Toast.makeText (LoginWithMobile.this, "Unsuccessful Login", Toast.LENGTH_SHORT).show ( );
                            }
                        });

                    }


                } catch (Exception e) {

                    Log.i ("tag  ", "######################################################################### catched 1 : " + e.getMessage ( ).toString ( ));


                }

            } catch (Exception ex) {

                Log.i ("tag ", "######################################################################### inside catched " + ex.getMessage ( ).toString ( ));

            }

            return null;
        }


    }

}
