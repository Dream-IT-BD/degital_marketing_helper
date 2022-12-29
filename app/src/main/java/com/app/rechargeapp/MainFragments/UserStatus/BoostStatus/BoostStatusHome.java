package com.app.rechargeapp.MainFragments.UserStatus.BoostStatus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.app.rechargeapp.R;
import com.google.android.material.tabs.TabLayout;

public class BoostStatusHome extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapterForBoostStatus adapter;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_status);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new FragmentAdapterForBoostStatus(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);


        // Create new Tab's
        tabLayout.addTab(tabLayout.newTab().setText("Completed"));
        tabLayout.addTab(tabLayout.newTab().setText("Running"));
        tabLayout.addTab(tabLayout.newTab().setText("Disabled"));
        tabLayout.addTab(tabLayout.newTab().setText("Pending"));


        // Tab on click listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

//                if (tab.getPosition() == 1){
//                    userStatusRunning();
//                }else if (tab.getPosition() == 2){
//                    userStatusDisabled();
//                }else if (tab.getPosition() ==3){
//                    userStatusPending();
//                }else{
//                    userStatusCompleted();
//                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}