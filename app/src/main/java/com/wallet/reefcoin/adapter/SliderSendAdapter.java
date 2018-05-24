package com.wallet.reefcoin.adapter;
/**
 * all required libraries imported here
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wallet.reefcoin.R;

import java.util.ArrayList;

/**
 * Created by "MD.Ibrahim Khalil" on 01-Mar-18.
 */

public class SliderSendAdapter extends PagerAdapter {
    /**
     * field instances of array list,context and inflater
     */
    ArrayList<String> coinNameList;
    Context mContext;
    LayoutInflater mLayoutInflater;

    /**
     * cocnstructor for getting the current context and the arraylist of values
     * @param context
     * @param arrayList
     */

    public SliderSendAdapter(Context context, ArrayList<String>arrayList) {
        this.mContext = context;
        this.coinNameList=arrayList;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * return total item count measuring the array list size
     * @return
     */

    @Override
    public int getCount() {
        return coinNameList.size();
    }

    /**
     * return each view by type casting to the parent layout
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    /**
     * initiating each item and its all views and setting up the values to the views
     * @param container
     * @param position
     * @return
     */

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        /**
         * inflating the views with defined layout
         */
        View itemView = mLayoutInflater.inflate(R.layout.slider_layout, container, false);

/**
 * type casting the views
 */
        TextView tvName = (TextView) itemView.findViewById(R.id.tv_coin_name);
        /**
         * setting text to the textview name
         */
        tvName.setText(coinNameList.get(position));
        /**
         * adding this view to the item view row
         */
        container.addView(itemView);
        /**
         * returning the whole view
         */
        return itemView;
    }
/**
 * destroy the item when it gone invisible
 */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        /**
         * destroy the item by removing the item from the container
         */
        container.removeView((RelativeLayout) object);
    }
}