package com.app.rechargeapp.MainFragments.PaymentHistory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragPaymentHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragPaymentHistory extends BottomSheetDialogFragment {

    ListView listView;
    Context mContext;
    String token;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragPaymentHistory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragPaymentHistory.
     */
    // TODO: Rename and change types and number of parameters
    public static fragPaymentHistory newInstance(String param1, String param2) {
        fragPaymentHistory fragment = new fragPaymentHistory();
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
        View view = inflater.inflate(R.layout.frag_payment_history, container, false);

        SharedPreferences sharedPreferences = mContext.getSharedPreferences("authToken", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","");

        List<DataModel> myDataOnList = new ArrayList<>();
        listView = view.findViewById(R.id.listView);


        RequestQueue queue = Volley.newRequestQueue(mContext);
        //String url ="https://dreamit.ishoppis.com/public/api/profile/list-boostPayment?token=" + token;
        String url = "https://backend.dreamitdevlopment.com/public/api/profile/list-boostPayment/?token="+token;


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i <= 100; i++){

                    try {
                        DataModel dataModel = new DataModel();

                        JSONObject jsonObject = response.getJSONObject(i);

                        dataModel.setPayment_date(jsonObject.getString("payment_date"));
                        dataModel.setPaid_amount(jsonObject.getString("paid_amount"));


                        myDataOnList.add(dataModel);
                        ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, myDataOnList);
                        listView.setAdapter(arrayAdapter);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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