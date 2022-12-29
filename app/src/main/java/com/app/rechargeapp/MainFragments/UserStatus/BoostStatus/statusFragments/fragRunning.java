package com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.statusFragments;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.app.rechargeapp.R;
import com.app.rechargeapp.MainFragments.UserStatus.BoostStatus.StatusDataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragRunning#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragRunning extends Fragment {

    Context mContext;
    String token;
//    private RecyclerView recyclerView;
//    private ArrayList<DataModel> arrayList;

    ListView listView;
    private static final String TAG = "fragRunning";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragRunning() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragRunning.
     */
    // TODO: Rename and change types and number of parameters
    public static fragRunning newInstance(String param1, String param2) {
        fragRunning fragment = new fragRunning();
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_running, container, false);

//        recyclerView = view.findViewById(R.id.recyclerView);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        arrayList = new ArrayList<>();


        listView = view.findViewById(R.id.listView);
        List<StatusDataModel> myDataOnList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        SharedPreferences sharedPreferences = mContext.getSharedPreferences("authToken", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","");

        //String url ="https://dreamit.ishoppis.com/public/api/profile/list-boost/?token="+token;
        String url = "https://backend.dreamitdevlopment.com/public/api/profile/list-boost/?token="+token;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i<=100; i++){
                        StatusDataModel statusDataModel = new StatusDataModel();

                        JSONObject jsonObject = response.getJSONObject(i);

                        statusDataModel.setUser_id(jsonObject.getInt("user_id"));
                        statusDataModel.setPage_name(jsonObject.getString("page_name"));
                        statusDataModel.setBoost_amount(jsonObject.getString("boost_amount"));
                        statusDataModel.setBoost_duration(jsonObject.getString("boost_duration"));
                        statusDataModel.setBoost_goal(jsonObject.getString("boost_goal"));


                        statusDataModel.getBoost_status(jsonObject.getString("boost_status"));

                        String test = statusDataModel.setBoost_status(jsonObject.getString("boost_status"));

//                        arrayList.add(new DataModel(statusDataModel.getPage_name(), statusDataModel.getBoost_amount(), statusDataModel.getBoost_duration()));

                        if (test.equals("running")){
                            myDataOnList.add(statusDataModel);
                            ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, myDataOnList);
                            listView.setAdapter(arrayAdapter);

                            Log.d(TAG, "onResponse: @@@@@@         Fragment Running Data" + test.toString());
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);

        return view;
    }
}