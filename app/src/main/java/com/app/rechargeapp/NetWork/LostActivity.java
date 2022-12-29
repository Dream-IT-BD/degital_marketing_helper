package com.app.rechargeapp.NetWork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.rechargeapp.R;
import com.app.rechargeapp.SecondMainActivity;

public class LostActivity extends AppCompatActivity {

    Button btnTryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lost_activity);



        btnTryAgain = findViewById(R.id.btnTryAgain);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LostActivity.this, SecondMainActivity.class));
                finish();
            }
        });


    }
}