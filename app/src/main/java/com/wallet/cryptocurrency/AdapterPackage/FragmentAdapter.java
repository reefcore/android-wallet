package com.wallet.cryptocurrency.AdapterPackage;
/**
 * all required libraries imported here
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibrahim Khalil on 25-Sep-17.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    /**
     * field instances array lists  of fragments and fragment titles
     */
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    /**
     * constructor for getting the current fragment manager
     * @param manager
     */

    public FragmentAdapter(FragmentManager manager) {
        super(manager);
    }

    /**
     * returning the fragment of each position
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    /**
     * counting the total fragment from arratlist size and return
     * @return
     */

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /**
     * adding fragment and fragment to the array lists
     * @param fragment
     * @param title
     */

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    /**
     * returning the title of each position
     * @param position
     * @return
     */

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
