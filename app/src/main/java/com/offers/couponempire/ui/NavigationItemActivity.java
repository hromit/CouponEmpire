package com.offers.couponempire.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.offers.couponempire.R;
import com.offers.couponempire.fragment.AboutUsFragment;
import com.offers.couponempire.fragment.FeedbackFragment;
import com.offers.couponempire.fragment.MyFavouritesfragment;
import com.offers.couponempire.fragment.MyNotificationsFragment;
import com.offers.couponempire.fragment.MyWalletFragment;

public class NavigationItemActivity extends AppCompatActivity {


    int id;
    int layout_id;

    public  static final int NAVDRAWER_ITEM_ABOUTUS=1;
    public  static final int NAVDRAWER_ITEM_FEEDBACK=2;
    public  static final int NAVDRAWER_ITEM_MYNOTIFICATIONS=5;
    public  static final int NAVDRAWER_ITEM_MYFAVOURITES=4;
    public  static final int NAVDRAWER_ITEM_MYWALLET=3;


    private Toolbar toolbar;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        id=getIntent().getIntExtra("yo",8);


        // get an instance of FragmentTransaction from your Activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //add a fragment

        String title = "CouponEmpire";

        switch (id) {

            case NAVDRAWER_ITEM_ABOUTUS:

                fragment = new AboutUsFragment();
                title="About Us";
                break;
            case NAVDRAWER_ITEM_FEEDBACK:

                fragment = new FeedbackFragment();;
                title="Feedback";
                break;
            case NAVDRAWER_ITEM_MYNOTIFICATIONS:

                fragment = new MyNotificationsFragment();
                title="Notifications";
                break;
            case NAVDRAWER_ITEM_MYFAVOURITES:

                fragment = new MyFavouritesfragment();
                title="My Favourites"
;                break;
            case NAVDRAWER_ITEM_MYWALLET:

                fragment = new MyWalletFragment();
                title="My Wallet";
                break;




        }

        fragmentTransaction.add(R.id.nav_frag, fragment);
        fragmentTransaction.commit();
        setContentView(R.layout.activity_navigation_item);

        toolbar= (Toolbar) findViewById(R.id.app_bar_nav_items);
     /*   setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notifications");*/
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.drawable.ic_backspace);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
