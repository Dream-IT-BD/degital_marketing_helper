package com.app.rechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    TextView auth_token;
    Button get, jimWork;
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auth_token = findViewById(R.id.auth_token);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("authToken", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","");
        auth_token.setText(token);
        get = findViewById(R.id.get);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recharge();
            }
        });

        jimWork = findViewById(R.id.jimWork);

        jimWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this, UserStatus.class));

                if (token.isEmpty()){
                    Toast.makeText(HomeActivity.this, "Login to access", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(HomeActivity.this, SecondMainActivity.class));
                }
            }
        });

    }

    private void recharge() {
        // ...
        Log.d(TAG, "recharge:     ................            " +  token);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://dreamit.ishoppis.com/public/api/profile/list-boost/?token="+token;


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse:              ...........        " +response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse:     .........." +error);
            }
        });
        queue.add(stringRequest);
    }
}