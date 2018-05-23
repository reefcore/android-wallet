package com.wallet.reefcoin.Fragment;
/**
 * all required libraries imported here
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wallet.reefcoin.R;

/**
 * Created by "MD.Ibrahim Khalil" on 27-Feb-18.
 */

public class SignupFragment extends Fragment {
    /**
     * Field instances of all views and variables
     */
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * assigning the layout of sign up screen and type casting the all child views of this
         */
        rootView = inflater.inflate(R.layout.sign_up, container, false);

        return rootView;
    }
}
