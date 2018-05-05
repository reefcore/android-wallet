package com.wallet.cryptocurrency.FragmentPackage;
/**
 * all required libraries imported here
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;
import com.wallet.cryptocurrency.ActivityPackage.ScanActivity;
import com.wallet.cryptocurrency.AdapterPackage.SliderSendAdapter;
import com.wallet.cryptocurrency.AdapterPackage.SliderTransactionAdapter;
import com.wallet.cryptocurrency.R;

import java.util.ArrayList;

/**
 * Created by "MD.Ibrahim Khalil" on 28-Feb-18.
 */

public class SendFragment extends Fragment {
    /**
     * field instances of all views and variables
     */
    View rootView;
    public static String qrCodeString = "";
    EditText etAddress;
    ImageButton btnScan;
    VerticalInfiniteCycleViewPager infiniteCycleViewPager;
    ArrayList<String> arrayListCoinName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * assigning the send layout
         */
        rootView = inflater.inflate(R.layout.send, container, false);
/**
 * type casting the all views
 */
        initialiseViews();
        /**
         * setting up the slider
         */
        setupSliderwithValues();

        /**
         * click listener of Scan button
         */
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * starting the transaction of scan screen
                 */
                startActivity(new Intent(getActivity(), ScanActivity.class));
            }
        });

        return rootView;
    }

    /**
     * this method will called when this page will continue from another task
     * and it will check for the qr code string is its not empty then it will set this to address
     * as this fragment will be in pause when user open the scan transaction to scan qr from this fragment
     * then when it back to this fragment this #on_resume will be called.here the qr code will be set to the etAddress field.
     * and then the qr code string set to empty
     */

    @Override
    public void onResume() {
        /**
         * if qr code string is empty not then the qr code will set to the etAddress
         * and then the qrcodeString will be empty
         */
        if (!qrCodeString.equals("")) {
            etAddress.setText(qrCodeString);
            qrCodeString = "";
        }
        super.onResume();
    }

    /**
     * type casting the all views
     */
    public void initialiseViews() {
        /**
         * type casting the views
         */
        infiniteCycleViewPager = (VerticalInfiniteCycleViewPager) rootView.findViewById(R.id.hicvp);
        etAddress = (EditText) rootView.findViewById(R.id.etAddress);
        btnScan = (ImageButton) rootView.findViewById(R.id.btn_scan);
    }

    public void setupSliderwithValues() {
        /**
         * assigning the demo values to the array list
         */
        arrayListCoinName = new ArrayList<String>();
        arrayListCoinName.add("BTC");
        arrayListCoinName.add("TCN");
        arrayListCoinName.add("DASH");
        arrayListCoinName.add("DUTCH");
        arrayListCoinName.add("NXT");
        /**
         * setting up the array list to the slider(infinteCycleViewPager)
         */
        infiniteCycleViewPager.setAdapter(new SliderSendAdapter(getActivity(), arrayListCoinName));

        /**
         * modifying the infinite cycle view pager as requirements
         */
        infiniteCycleViewPager.setScrollDuration(500);
        infiniteCycleViewPager.setMediumScaled(true);
        infiniteCycleViewPager.setMaxPageScale(0.8F);
        infiniteCycleViewPager.setMinPageScale(0.5F);
        infiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
        infiniteCycleViewPager.setMinPageScaleOffset(5.0F);

    }
}
