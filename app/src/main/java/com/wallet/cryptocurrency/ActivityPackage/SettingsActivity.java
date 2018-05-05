package com.wallet.cryptocurrency.ActivityPackage;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.wallet.cryptocurrency.FragmentPackage.SendFragment;
import com.wallet.cryptocurrency.R;
import com.wallet.cryptocurrency.UtilPackage.CustomZXingScannerView;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


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
