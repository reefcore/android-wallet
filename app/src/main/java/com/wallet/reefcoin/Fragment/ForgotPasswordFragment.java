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
import android.widget.Button;
import android.widget.ImageButton;

import com.wallet.reefcoin.Activity.LoginActivity;
import com.wallet.reefcoin.R;

/**
 * Created by "MD.Ibrahim Khalil" on 28-Feb-18.
 */

public class ForgotPasswordFragment extends Fragment {
    /**
     * field instance of all views
     */
    View rootView;
    ImageButton imageButtonBack;
    Button btnSendNow;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * assigning the layout of forgot password and type casting of all child views
         */
       rootView=inflater.inflate(R.layout.forgot_password,container,false);
        /**
         * type casting the all views
         */
        initialiseViews();
        /**
         * click listener of image button back
         */
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * popping up the forgot password fragment from fragment manager
                 */
                LoginActivity.manager.popBackStackImmediate();

            }
        });


        /**
         * click listener of send now button
         */
        btnSendNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * do api call
                 */
            }
        });
        return rootView;
    }

    /**
     * all views will be type casted here
     */
    public void initialiseViews(){
        /**
         * type casting the all views
         */
        imageButtonBack=(ImageButton)rootView.findViewById(R.id.image_button_back);
        btnSendNow=(Button) rootView.findViewById(R.id.btn_Send_now);
    }
}
