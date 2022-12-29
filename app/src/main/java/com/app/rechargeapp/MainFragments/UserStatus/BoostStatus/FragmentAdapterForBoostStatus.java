package com.app.rechargeapp.MainFragments.UserStatus.BoostStatus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragCompleted;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragDisabled;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragPending;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragRunning;

public class FragmentAdapterForBoostStatus extends FragmentStateAdapter {
    public FragmentAdapterForBoostStatus(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new fragRunning();
            case 2:
                return new fragDisabled();
            case 3:
                return new fragPending();
        }
        return new fragCompleted();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
