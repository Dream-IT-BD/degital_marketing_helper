package com.app.rechargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    TextInputEditText email,password;
    Button login_btn,next;
    SharedPreferences sharedPreferences;
    String myMainAuthToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sharedPreferences = getSharedPreferences("authToken", Context.MODE_PRIVATE);
        login();

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    private void login() {
        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginRequest();

                nextActivityValidator();
            }
        });
    }

    private void nextActivityValidator() {

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("authToken", Context.MODE_PRIVATE);
        myMainAuthToken = sharedPreferences.getString("token","");

//        if (myMainAuthToken.isEmpty()){
//            Toast.makeText(MainActivity.this, "Login to access", Toast.LENGTH_SHORT).show();
//        }else{
//            startActivity(new Intent(MainActivity.this, SecondMainActivity.class));
//            finish();
//        }
    }

    private void loginRequest() {

        RequestQueue queue = Volley.newRequestQueue(this);
        //String url ="https://dreamit.ishoppis.com/public/api/login";
        String url = "https://backend.dreamitdevlopment.com/public/api/login";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: @@@@@@@" +response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            String token = jsonObject.getString("access_token");

                            Log.d(TAG, "onResponse:    token           :     " + token);

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("token", token);
                            editor.apply();

                            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("authToken", Context.MODE_PRIVATE);
                            token = sharedPreferences.getString("token","");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse:    " +error);
            }
        }) {
            @Override
            protected Map<String, String> getParams(){
                String email1 = email.getText().toString();
                String pass = password.getText().toString();

                Log.d(TAG, "getParams: ..........................." + email1 + "   ....  "  + pass);

                Map<String, String> params = new HashMap<>();
                params.put("email",email1);
                params.put("password",pass);
                return params;
            }
        };
        queue.add(stringRequest);

    }

}