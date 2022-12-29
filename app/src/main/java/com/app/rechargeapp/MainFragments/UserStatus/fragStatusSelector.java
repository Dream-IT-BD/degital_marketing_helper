package com.app.rechargeapp.MainFragments.UserStatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.BoostStatusHome;
import com.app.rechargeapp.MainFragments.UserStatus.LikeStatus.LikeStatusHome;
import com.app.rechargeapp.R;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragStatusSelector#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragStatusSelector extends Fragment {

    Context mContext;
    Button btnGoToBoostStatus, btnGoToLikeBoostStatus;
    private static final String TAG = "fragStatusSelector";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragStatusSelector() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragStatusSelector.
     */
    // TODO: Rename and change types and number of parameters
    public static fragStatusSelector newInstance(String param1, String param2) {
        fragStatusSelector fragment = new fragStatusSelector();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_status_selector, container, false);

        btnGoToBoostStatus = view.findViewById(R.id.btnNormalBoost);
        btnGoToLikeBoostStatus = view.findViewById(R.id.btnLikeBoost);


        btnGoToBoostStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: @@@@@@@@@@@@@@                         Boost Status BTN Clicked");
//                fragUserStatus fragUserStatus = new fragUserStatus();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragStatusSelector, fragUserStatus, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
                startActivity(new Intent(getActivity().getApplication(), BoostStatusHome.class));
            }
        });

        btnGoToLikeBoostStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: @@@@@@@@@@@                         Like Boost button clicked");
                startActivity(new Intent(getActivity().getApplication(), LikeStatusHome.class));
            }
        });

        return  view;
    }
}