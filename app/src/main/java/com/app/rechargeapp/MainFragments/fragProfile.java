package com.app.rechargeapp.MainFragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.rechargeapp.MainFragments.Models.UserProfileModel;
import com.app.rechargeapp.MainFragments.PaymentHistory.fragPaymentHistory;
import com.app.rechargeapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragProfile extends Fragment {

    TextView tvUserName, tvEmail, tvTotalbill, tvPaid;
    Context mContext;
    View view;
    String token;
    Button btnPaymentHistory, button2;

    String name, email;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static fragProfile newInstance(String param1, String param2) {
        fragProfile fragment = new fragProfile();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.frag_profile, container, false);

        tvUserName = view.findViewById(R.id.tvUserName);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTotalbill = view.findViewById(R.id.tvTotalbill);
        tvPaid = view.findViewById(R.id.tvPaid);
        button2 = view.findViewById(R.id.button2);

        UserProfileModel userProfileModel = new UserProfileModel();

        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        SharedPreferences sharedPreferences = mContext.getSharedPreferences("authToken", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","");

        //String url ="https://dreamit.ishoppis.com/public/api/customers/view-profile/?token="+token;
        //String url = "https://backend.dreamitdevlopment.com/public/api/customers/view-profile/?token="+token;
        String url = "https://backend.dreamitdevlopment.com/public/api/client/view-profile/?token="+token;


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override

            public void onResponse(JSONObject response) {
                String strTotalBill = null;

                try {

                    JSONObject customersData = response.getJSONObject("customers");

                    userProfileModel.setName(customersData.getString("name"));
                    userProfileModel.setEmail(customersData.getString("email"));

                    // Getting User bills

                    userProfileModel.setTotalBill(response.getString("totalBill"));
                    userProfileModel.setPaidAmount(response.getString("paidAmount"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                tvUserName.setText(userProfileModel.getName());
                tvEmail.setText(userProfileModel.getEmail());
                tvTotalbill.setText(userProfileModel.getTotalBill());
                tvPaid.setText(userProfileModel.getPaidAmount());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, "Error !!!", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonObjectRequest);


        // Open Payment history fragment
        btnPaymentHistory = view.findViewById(R.id.btnPaymentHistory);

        btnPaymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPaymentHistory fragPaymentHistory = new fragPaymentHistory();
                fragPaymentHistory.show(getActivity().getSupportFragmentManager(),fragPaymentHistory.getTag());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrising fragPrising = new fragPrising();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragProfileID, fragPrising, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}