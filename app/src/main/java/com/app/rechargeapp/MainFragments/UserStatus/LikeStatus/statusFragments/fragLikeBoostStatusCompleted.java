package com.app.rechargeapp.MainFragments.UserStatus.LikeStatus.statusFragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.StatusDataModel;
import com.app.rechargeapp.MainFragments.UserStatus.LikeStatus.LikeStatusDataModel;
import com.app.rechargeapp.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragLikeBoostStatusCompleted#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragLikeBoostStatusCompleted extends Fragment {

    Context mContext;
    String token;
    ListView listView;
    private static final String TAG = "fragLikeBoostCompleted";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragLikeBoostStatusCompleted() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragLikeBoostCompleted.
     */
    // TODO: Rename and change types and number of parameters
    public static fragLikeBoostStatusCompleted newInstance(String param1, String param2) {
        fragLikeBoostStatusCompleted fragment = new fragLikeBoostStatusCompleted();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        mContext = context;
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
        View view = inflater.inflate(R.layout.frag_like_boost_status_completed, container, false);
        List<LikeStatusDataModel> myDataOnList = new ArrayList<>();
        listView = view.findViewById(R.id.listView);

        SharedPreferences sharedPreferences = mContext.getSharedPreferences("authToken", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","");

        RequestQueue queue = Volley.newRequestQueue(mContext);
        String url ="https://backend.dreamitdevlopment.com/public/api/profile/list-like-boost/?token="+token;


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG, "onResponse: @@@@@@@@@@@@@@                            Response Success");

                try {
                    JSONArray jsonArray = response.getJSONArray("completedBoost");


                    for (int i = 0; i<100; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        LikeStatusDataModel dataModel = new LikeStatusDataModel();

                        dataModel.setLike_amount(jsonObject.getInt("like_amount"));
                        dataModel.setLike_gained(jsonObject.getInt("like_gained"));
                        dataModel.setPage(jsonObject.getString("page"));
                        dataModel.setStatus(jsonObject.getString("status"));


                        myDataOnList.add(dataModel);
                        ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, myDataOnList);
                        listView.setAdapter(arrayAdapter);
                    }


                    //Toast.makeText(mContext, jsonArray.toString(), Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onResponse: @@@@@@@@@@@@@@                            Response Error");
            }
        });

        queue.add(jsonObjectRequest);

        return view;
    }
}