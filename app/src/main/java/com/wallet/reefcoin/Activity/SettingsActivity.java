package com.wallet.reefcoin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.wallet.reefcoin.R;


public class SettingsActivity extends AppCompatActivity {
    /**
     * Field instances of all views and variables
     */
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * setting up the content view
         */
        setContentView(R.layout.activity_settings);

        /**
         * type casting the all views will goes here
         */
        initialiseViews();
        /**
         * click listener of back button
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * finishing the transaction
                 */
                finish();
            }
        });
    }

    public void initialiseViews() {
        /**
         * type casting the views
         */
        back = (ImageButton) findViewById(R.id.image_button_back);
    }
}
