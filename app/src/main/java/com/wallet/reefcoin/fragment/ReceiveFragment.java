package com.wallet.reefcoin.fragment;
/**
 * all required libraries imported here
 */

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.wallet.reefcoin.R;

/**
 * Created by "MD.Ibrahim Khalil" on 28-Feb-18.
 */

public class ReceiveFragment extends Fragment {
    /**
     * Field instances of all views and variables
     */
    View rootView;
    TextView tvQrCode, tvGenerateNewCode;
    ImageView imageQr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * assigning the layout of Receive page and type casting of all child views
         */
        rootView = inflater.inflate(R.layout.receive, container, false);
        /**
         * type casting the all views
         */
        initialiseViews();

        return rootView;
    }

    //TODO:: Receive By generate QR. Then send on node.
    public void createQrCode(final String code) {
        /**
         * setting up the dialog to showing the user that the qr code is generating
         */
        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Creating QR");
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        dialog.show();
        /**
         * a thread is used to create the qr code as it takes some times much time and freeze the ui so run it on a separate thread
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * creating a object of Qr code write class
                 */
                QRCodeWriter writer = new QRCodeWriter();
                try {
                    /**
                     * encoding the string to qr code format with 512*512 size  and assign to the bit matrix
                     */
                    BitMatrix bitMatrix = writer.encode(code, BarcodeFormat.QR_CODE, 512, 512);
                    /**
                     * getting height and width of bit matrix
                     */
                    int width = bitMatrix.getWidth();
                    int height = bitMatrix.getHeight();
                    /**
                     * creating bitmap from bit matrix height and  width
                     */
                    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                    /**
                     * looping through the bmp using height and width and assign the respected value to it
                     */
                    for (int x = 0; x < width; x++) {
                        for (int y = 0; y < height; y++) {
                            bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                        }
                    }
                    /**
                     * assign bmp to bmp final to use it into run on ui thread
                     */
                    final Bitmap bmpFinal = bmp;
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            /**
                             * setting up the bmp final to the image qr image view
                             */
                            imageQr.setImageBitmap(bmpFinal);
                            /**
                             * setting up the qr code string value to the tvqrcode text view
                             */
                            tvQrCode.setText(code.concat(""));
                            /**
                             * dismiss the dialog as the qr generating and showing task is finished
                             */
                            if (dialog.isShowing()) {
                                dialog.dismiss();
                            }
                        }
                    });
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    /**
     * this is a callback for when the fragment is visible to user and the qr code is generated only when this page is visible
     * @param isVisibleToUser
     */

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        /**
         * if this page is visible to user then create qr code method will executed
         */
        if (isVisibleToUser) {
            /**
             * create the qr code with given string
             */
            createQrCode("this is test QR code");
        }
        super.setUserVisibleHint(isVisibleToUser);
    }



    /**
     * type casting the all views
     */
    public void initialiseViews() {
        tvQrCode = (TextView) rootView.findViewById(R.id.tvQrcode);
        imageQr = (ImageView) rootView.findViewById(R.id.imageQr);
        tvGenerateNewCode = (TextView) rootView.findViewById(R.id.tv_generate_new_code);
        /**
         * setting the underline on the text
         */
        tvGenerateNewCode.setPaintFlags(tvGenerateNewCode.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}
