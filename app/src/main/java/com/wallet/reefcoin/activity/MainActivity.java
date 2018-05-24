package com.wallet.reefcoin.activity;
/**
 * all required libraries imported here
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wallet.reefcoin.adapter.FragmentAdapter;
import com.wallet.reefcoin.fragment.TransactionsFragment;
import com.wallet.reefcoin.fragment.ReceiveFragment;
import com.wallet.reefcoin.fragment.SendFragment;
import com.wallet.reefcoin.R;

public class MainActivity extends AppCompatActivity {
    /**
     * field instance of views and variables
     */
    TabLayout tableLayout;
    ViewPager viewPager;
    public static ImageButton btnHam;
    LinearLayout transactionLayout, receiveLayout, sendLayout, addLayout, personalLayout;
    ImageButton btnSettings, btnSettingTop;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * setting up the content view of this screen
         */
        setContentView(R.layout.activity_main);
        /**
         * type casting the all views
         */
        initialiseViews();
        /**
         * click listener of navigation ham button which will open and close the navigation drawer
         */
//        btnHam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                /**
//                 * if the drawer is open then the drawer will be closed and else the drawer will be opened
//                 */
//                if (drawer.isDrawerOpen(GravityCompat.START)) {
//                    drawer.closeDrawer(GravityCompat.START);
//                } else {
//                    drawer.openDrawer(GravityCompat.START);
//                }
//            }
//        });

        /**
         * setup fragments
         */
        setupFragments();
        /**
         * set the default position of fragment to transaction page which position is 1
         */
        viewPager.setCurrentItem(1);

        /**
         * click listener of receiveLayout which will redirect to receive page
         */
        receiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * first close the drawer if its open and then changing the fragment position to 0.the 0 is the position of receive page
                 */
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                viewPager.setCurrentItem(0, true);
            }
        });
        /**
         * click listener of sendLayout which will redirect to send page
         */

        sendLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * first close the drawer if its open and then changing the fragment position to 2.the 2 is the position of send page
                 */
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                viewPager.setCurrentItem(2, true);
            }
        });


        /**
         * click listener of settings button  which will redirect to settings page
         */
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * starting the transaction of settings page
                 */
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });


        /**
         * click listener of toolbar settings button which will redirect to settings page
         */
        btnSettingTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * starting the transaction of settings page
                 */
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        /**
         * click listener of transactionLayout which will redirect to transaction page
         */

        transactionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * first close the drawer if its open and then changing the fragment position to 1.the 1 is the position of transaction page
                 */
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                viewPager.setCurrentItem(1, true);
            }
        });

        /**
         * click listener of personalLayout which will redirect to personal page and will set position to transaction page
         */
        personalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * first close the drawer if its open and then changing the fragment position to 1.the 1 is the position of transaction page
                 */

                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                viewPager.setCurrentItem(1, true);
            }
        });
    }

    /**
     * on back button pressed this method will be called
     */
    @Override
    public void onBackPressed() {
        /**
         * assigning the drawer and then if the drawer is open the drawer will be closed else the transaction will be destroyed
         */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * this method is used to create the tabs with vertical icons
     */
    public void setupTabWithIcons() {
        /**
         * for vertical icon with text in tab here a custom tab layout is used which will found in layout folder
         * As there are 3 tabs we used this layout for 3 times
         */
        /**
         * type casting the textview of custom layout
         */
        TextView tvReceive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_style, null);
        /**
         * setting text
         */
        tvReceive.setText("Receive");
        /**
         * setting up the icon with the text
         */
        tvReceive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.wallet, 0, 0);
        /**
         * getting the receive tab and setting up the custom view to it
         */
        tableLayout.getTabAt(0).setCustomView(tvReceive);

        /**
         * type casting the textview
         */
        TextView tvTransaction = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_style, null);
        /**
         * setting text
         */
        tvTransaction.setText("Transaction");

        /**
         * setting the icon with the text
         */
        tvTransaction.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.transactions, 0, 0);
/**
 * getting the tab of transaction and setting up the custom view
 */
        tableLayout.getTabAt(1).setCustomView(tvTransaction);


        /**
         * type casting the text view
         */
        TextView tvSend = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_style, null);
        /**
         * setting text
         */
        tvSend.setText("Send");
        /**
         * setting icon with text
         */
        tvSend.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.send, 0, 0);
        /**
         * getting the tab of send and setting up the custom view
         */
        tableLayout.getTabAt(2).setCustomView(tvSend);
    }

    public void initialiseViews() {
        /**
         * type casting  the all views here
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tableLayout = (TabLayout) findViewById(R.id.tabs);
        transactionLayout = (LinearLayout) findViewById(R.id.transaction);
        receiveLayout = (LinearLayout) findViewById(R.id.receive);
        sendLayout = (LinearLayout) findViewById(R.id.send);
        addLayout = (LinearLayout) findViewById(R.id.add);
        personalLayout = (LinearLayout) findViewById(R.id.personal);
        btnSettings = (ImageButton) findViewById(R.id.btn_settings);
        btnSettingTop = (ImageButton) findViewById(R.id.btn_setting);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        btnHam = (ImageButton) findViewById(R.id.ham);
    }

    public void setupFragments() {
        /**
         * setting up the all fragments with the custom fragment adapter
         */
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReceiveFragment(), "Receive");
        adapter.addFragment(new TransactionsFragment(), "Activity");
        adapter.addFragment(new SendFragment(), "Send");
        /**
         * setting up the adapter with view pager slider
         */
        viewPager.setAdapter(adapter);
        /**
         * attach the view pager with tab layout so that they will work together
         */
        tableLayout.setupWithViewPager(viewPager);
        /**
         * calling the method of custom vertical icon with text tabs
         */
        setupTabWithIcons();
    }
}
