package com.app.rechargeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.app.rechargeapp.MainFragments.UserStatus.fragStatusSelector;
import com.app.rechargeapp.MainFragments.AddNewFrags.fragBoostRequestHome;
import com.app.rechargeapp.MainFragments.fragDashboard;
import com.app.rechargeapp.MainFragments.fragPrising;
import com.app.rechargeapp.MainFragments.fragProfile;
import com.app.rechargeapp.NetWork.CheckNetwork;
import com.app.rechargeapp.NetWork.LostActivity;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class SecondMainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigationBar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main_activity);



        // Check Internet Connection
        if(CheckNetwork.isInternetAvailable(SecondMainActivity.this)){
            Toast.makeText(this, "Internet Connection successful", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(SecondMainActivity.this, LostActivity.class);
            startActivity(intent);
            finish();
            //Toast.makeText(SecondMainActivity.this,"No Internet Connection",1000).show();
        }


        meowBottomNavigationBar = findViewById(R.id.bottomNavigationBar);

        meowBottomNavigationBar.add(new MeowBottomNavigation.Model(1,R.drawable.status_icon));
        meowBottomNavigationBar.add(new MeowBottomNavigation.Model(2,R.drawable.add_icon));
        meowBottomNavigationBar.add(new MeowBottomNavigation.Model(3,R.drawable.home_icon));
        meowBottomNavigationBar.add(new MeowBottomNavigation.Model(4,R.drawable.prising_icon));
        meowBottomNavigationBar.add(new MeowBottomNavigation.Model(5,R.drawable.profile_icon));

        meowBottomNavigationBar.show(3,true);

        replace(new fragDashboard());
        meowBottomNavigationBar.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 1:
//                        replace(new fragUserStatus());
                        replace(new fragStatusSelector());
                        break;
                    case 2:
                        replace(new fragBoostRequestHome());
                        break;
                    case 3:
                        replace(new fragDashboard());
                        break;
                    case 4:
                        replace(new fragPrising());
                        break;
                    case 5:
                        replace(new fragProfile());
                        break;
                }
                return null;
            }
        });
    }

    private void replace(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}