package com.wallet.reefcoin.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.zxing.Result;
import com.wallet.reefcoin.fragment.SendFragment;
import com.wallet.reefcoin.R;
import com.wallet.reefcoin.UtilPackage.CustomZXingScannerView;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class ScanActivity extends AppCompatActivity {
    /**
     * Field instance of all views and variables
     */
    ZXingScannerView qrCodeReaderView;
    ImageButton btnflash, btncamera;
    boolean f = false, n = false;
    ImageButton back;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /**
         * setting up the content view of this screen
         */
        setContentView(R.layout.activity_scan);

        /**
         * type casting the all views
         */
        initialiseViews();

        /**
         * set the auto focus of camera true
         */
        qrCodeReaderView.setAutoFocus(true);
        /**
         * initially set up the flash false
         */
        qrCodeReaderView.setFlash(false);
        /**
         * start the camera for qr code scan
         */
        qrCodeReaderView.startCamera();
        /**
         * this is the callback when the qr code will be read successfully
         */
        qrCodeReaderView.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result result) {
/**
 * setting the result of qr code scan to the send page address
 */
                SendFragment.qrCodeString = result.getText().toString();
                /**
                 * finishing this transaction
                 */
                finish();
            }
        });

        /**
         * click listener of back button
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * finishing this transaction
                 */
                finish();
            }
        });
        /**
         * click listener of the camera button
         */
        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * switching the camera to front to rear and rear to front
                 */
                /**
                 * checking this boolen value for if it is first time click if it is first time then the front camera will be start and set f true
                 * else starting the rear camera and set f false
                 */
                if (!f) {
                    /**
                     * stop the current camera
                     */
                    qrCodeReaderView.stopCamera();
                    /**
                     * start the rear front camera
                     */
                    qrCodeReaderView.startCamera(1);
                    /**
                     * setting the boolean value to f true
                     */
                    f = true;
                } else {
                    /**
                     * stop the current camera
                     */
                    qrCodeReaderView.stopCamera();
                    /**
                     * start the rear camera
                     */
                    qrCodeReaderView.startCamera();
                    /**
                     * setting up the boolean value of f false
                     */
                    f = false;
                }
            }
        });

        /**
         * click listener of flash button
         */
        btnflash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * checking the boolean value for if flash is on then the flash will be off
                 * else the flash will be on
                 */
                if (!n) {
                    /**
                     * setting the flash on
                     */
                    qrCodeReaderView.setFlash(true);
                    /**
                     * setting the boolean value to n true
                     */
                    n = true;
                } else {
                    /**
                     * setting the flash off
                     */
                    qrCodeReaderView.setFlash(false);
                    /**
                     * setting the boolean value to n false
                     */
                    n = false;
                }

            }
        });
/**
 * click listener of back button
 */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * finishing this transaction
                 */
                finish();
            }
        });
    }

    /**
     * this method will type cast the all views of this screen
     */
    public void initialiseViews() {
        // Programmatically initialize the scanner view
        qrCodeReaderView = new ZXingScannerView(this) {

            @Override
            protected IViewFinder createViewFinderView(Context context) {
                return new CustomZXingScannerView(context);
            }

        };
        relativeLayout = (RelativeLayout) findViewById(R.id.rel1);
        relativeLayout.addView(qrCodeReaderView);
        btnflash = (ImageButton) findViewById(R.id.flash);
        back = (ImageButton) findViewById(R.id.image_button_back);
        btncamera = (ImageButton) findViewById(R.id.camera);
    }
}
