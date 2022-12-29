package com.app.rechargeapp.MainFragments.UserStatus.LikeStatus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragCompleted;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragDisabled;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragPending;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments.fragRunning;
import com.app.rechargeapp.MainFragments.UserStatus.LikeStatus.statusFragments.fragLikeBoostStatusCompleted;
import com.app.rechargeapp.MainFragments.UserStatus.LikeStatus.statusFragments.fragLikeBoostStatusDisabled;
import com.app.rechargeapp.MainFragments.UserStatus.LikeStatus.statusFragments.fragLikeBoostStatusPending;
import com.app.rechargeapp.MainFragments.UserStatus.LikeStatus.statusFragments.fragLikeBoostStatusRunning;

public class FragmentAdapterForLikeBoostStatus extends FragmentStateAdapter {
    public FragmentAdapterForLikeBoostStatus(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new fragLikeBoostStatusRunning();
            case 2:
                return new fragLikeBoostStatusDisabled();
            case 3:
                return new fragLikeBoostStatusPending();
        }
        return new fragLikeBoostStatusCompleted();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
