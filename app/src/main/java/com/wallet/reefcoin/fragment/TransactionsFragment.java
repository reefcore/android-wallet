package com.wallet.reefcoin.fragment;
/**
 * all required libraries imported here
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;
import com.wallet.reefcoin.adapter.ReceiveandSendAdapter;
import com.wallet.reefcoin.adapter.SliderTransactionAdapter;
import com.wallet.reefcoin.R;

import java.util.ArrayList;

/**
 * Created by "MD.Ibrahim Khalil" on 28-Feb-18.
 */

public class TransactionsFragment extends Fragment {
    /**
     * Field instances of all views and variables
     */
    View rootView;
    RecyclerView recyclerView;
    LinearLayout btnReceived, btnSend;
    View borderRececived, borderSend;
    VerticalInfiniteCycleViewPager infiniteCycleViewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * assigning the layout of Transaction screen
         */
        rootView = inflater.inflate(R.layout.transaction, container, false);
        /**
         * type casting all views
         */
      initialiseViews();

        /**
         * setting up the layout manager to recycler view and set the data to the adapter
          */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        /**
         * here 0 is the type which mean receive and the 0 is default
         */
        recyclerView.setAdapter(new ReceiveandSendAdapter(getActivity(),0));

        /**
         * setting up the slider
         */
       setupSlider();


        /**
         * initially setup the receive visible and send not visible
         */
        borderRececived.setVisibility(View.VISIBLE);
        borderSend.setVisibility(View.GONE);

        /**
         * click listener of receive
         */

        btnReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * setting receive visible,send not visible and refreshing recycler view with new data as requirements
                 */

                borderRececived.setVisibility(View.VISIBLE);
                borderSend.setVisibility(View.GONE);
                /**
                 * setting up adapter with recycler view
                 * here 0 is the type which means receive
                 */
                recyclerView.setAdapter(new ReceiveandSendAdapter(getActivity(),0));
            }
        });
        /**
         * click listener of send
         */
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * setting up receive not visible,send visible and refreshing recycler view with new data as requirements
                 */
                borderRececived.setVisibility(View.GONE);
                borderSend.setVisibility(View.VISIBLE);
                /**
                 * setting up adapter with recycler view
                 * here 1 is the type which means send
                 */
                recyclerView.setAdapter(new ReceiveandSendAdapter(getActivity(),1));
            }
        });
        return rootView;
    }

    /**
     * type casting all views
     */
    public void initialiseViews(){

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        borderRececived = (View) rootView.findViewById(R.id.border_receive);
        borderSend = (View) rootView.findViewById(R.id.border_send);
        btnReceived = (LinearLayout) rootView.findViewById(R.id.btn_received);
        btnSend = (LinearLayout) rootView.findViewById(R.id.btn_send);
        infiniteCycleViewPager = (VerticalInfiniteCycleViewPager) rootView.findViewById(R.id.hicvp);
    }

    /**
     * setting up the slider with demo data and modifying the infinite cycle view pager as requirements
     */
    public void setupSlider(){
        /**
         * defining the data by array list
         */
        ArrayList<String> arrayListCoinName = new ArrayList<String>();
        arrayListCoinName.add("BTC");
        arrayListCoinName.add("TCN");
        arrayListCoinName.add("DASH");
        arrayListCoinName.add("DUTCH");
        arrayListCoinName.add("NXT");
        /**
         * setting up the data with adapter in infinite cycle view pager
         */
        infiniteCycleViewPager.setAdapter(new SliderTransactionAdapter(getActivity(), arrayListCoinName));

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
