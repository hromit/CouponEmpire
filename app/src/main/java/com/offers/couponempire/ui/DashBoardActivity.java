package com.offers.couponempire.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.maps.MapsInitializer;
import com.offers.couponempire.R;
import com.offers.couponempire.anim.AnimationUtils;
import com.offers.couponempire.extras.SortListener;
import com.offers.couponempire.fragment.CouponsNearByFragment;
import com.offers.couponempire.fragment.FragmentBoxOffice;
import com.offers.couponempire.fragment.FragmentSearch;
import com.offers.couponempire.fragment.FragmentUpcoming;
import com.offers.couponempire.fragment.NativeGridGplayFragment;
import com.offers.couponempire.fragment.NativeMaterialCardFragment;
import com.offers.couponempire.fragment.NativeRecyclerViewMaterialCardFragment;
import com.offers.couponempire.fragment.NearByFragment;
import com.offers.couponempire.fragment.RootFragment;
import com.offers.couponempire.fragment.RootFragment_four;
import com.offers.couponempire.fragment.RootFragment_one;
import com.offers.couponempire.fragment.RootFragment_three;
import com.offers.couponempire.fragment.RootFragment_two;
import com.offers.couponempire.utils.Utils;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class DashBoardActivity extends BaseActivity implements MaterialTabListener, View.OnClickListener{


    //int representing our 0th tab corresponding to the Fragment where search results are dispalyed
    public static final int TAB_SEARCH_RESULTS = 0;
    //int corresponding to our 1st tab corresponding to the Fragment where box office hits are dispalyed
    public static final int TAB_HITS = 1;
    //int corresponding to our 2nd tab corresponding to the Fragment where upcoming movies are displayed
    public static final int TAB_UPCOMING = 2;
    //int corresponding to our 2nd tab corresponding to the Fragment where upcoming movies are displayed
    public static final int TAB_UPCOMING1 = 3;
    //int corresponding to our 2nd tab corresponding to the Fragment where upcoming movies are displayed
    public static final int TAB_UPCOMING2 = 4;
    //int corresponding to the number of tabs in our Activity
    public static final int TAB_COUNT = 5;

    //tag associated with the FAB menu button that sorts by name
    private static final String TAG_SORT_NAME = "sortName";
    //tag associated with the FAB menu button that sorts by date
    private static final String TAG_SORT_DATE = "sortDate";
    //tag associated with the FAB menu button that sorts by ratings
    private static final String TAG_SORT_RATINGS = "sortRatings";


    //a layout grouping the toolbar and the tabs together
    private ViewGroup mContainerToolbar;
    private android.support.v7.widget.Toolbar mToolbar;
    private MaterialTabHost mTabHost;
    private ViewPager mPager;
    private ViewPagerAdapter mAdapter;

    private FloatingActionButton mFAB;
    private FloatingActionMenu mFABMenu;

  /*  public String DEFAULT="default";
    com.github.clans.fab.FloatingActionMenu menu2;

    private com.github.clans.fab.FloatingActionButton fab12;
    private com.github.clans.fab.FloatingActionButton fab22;
    private com.github.clans.fab.FloatingActionButton fab32;*/


    private com.github.clans.fab.FloatingActionButton fab1;
    private com.github.clans.fab.FloatingActionButton fab2;
    private com.github.clans.fab.FloatingActionButton fab3;

    private List<com.github.clans.fab.FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();


    TextView signin,location,feedback,aboutus;

    boolean issignedin;
    public SharedPreferences sharedPreferences;



    @Override
    protected int getSelfNavDrawerItem() {
        return NAVDRAWER_ITEM_NATIVE_CARDSLIB;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        setContentView(R.layout.activity_dash_board2);
        //issignedin=  sharedPreferences.getBoolean("issignedin",false);

/*
        MapsInitializer.initialize(DashBoardActivity.this);
*/

       /* SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("issignedin",false);
        editor.commit();*/

        signin = (TextView) findViewById(R.id.signin);
        location = (TextView) findViewById(R.id.location);
        feedback= (TextView) findViewById(R.id.feedback);
        aboutus = (TextView) findViewById(R.id.aboutus);



        if(!sharedPreferences.getBoolean("issignedin",false))
        {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.navigation_drawer_account_view);
            frameLayout.setVisibility(View.GONE);
            signin.setVisibility(View.VISIBLE);
        }


        if(sharedPreferences.getBoolean("issignedin",false))
        {
            /*FrameLayout frameLayout = (FrameLayout) findViewById(R.id.navigation_drawer_account_view);
            frameLayout.setVisibility(View.GONE);*/
            signin.setVisibility(View.INVISIBLE);
        }

        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.navigation_drawer_user_account_picture_profile1);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("issignedin",false);
                editor.commit();

                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.navigation_drawer_account_view);
                frameLayout.setVisibility(View.GONE);


                signin.setVisibility(View.VISIBLE);

            }
        });


          signin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(getBaseContext(),RegisterUserActivity.class);
                  startActivity(intent);
              }
          });

          location.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  Utils.showAbout(DashBoardActivity.this);

              }
          });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), NavigationItemActivity.class);
                intent.putExtra("yo",2);
                startActivity(intent);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(),NavigationItemActivity.class);
                intent.putExtra("yo",1);
                startActivity(intent);
            }
        });
    /*    fab12 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab12);
        fab22 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab22);
        fab32 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab32);

        menu2 = (com.github.clans.fab.FloatingActionMenu) findViewById(R.id.menu2);



        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DEFAULT="one";
                Fragment fragment = (Fragment) mAdapter.instantiateItem(mPager, mPager.getCurrentItem());

                Toast.makeText(getBaseContext(),"ss0",Toast.LENGTH_LONG).show();
            }
        });*/
    //    setupFAB();
        setupTabs();
        setupDrawer();
        //animate the Toolbar when it comes into the picture
    //    AnimationUtils.animateToolbarDroppingDown(mContainerToolbar);
       /* final com.github.clans.fab.FloatingActionMenu menu1 = (com.github.clans.fab.FloatingActionMenu) findViewById(R.id.menu2);
        final com.github.clans.fab.FloatingActionButton programFab1 = new com.github.clans.fab.FloatingActionButton(this);
        programFab1.setButtonSize(com.github.clans.fab.FloatingActionButton.SIZE_MINI);
        programFab1.setLabelText("Programmatically added button");
        programFab1.setImageResource(R.drawable.ic_edit);
        menu1.addMenuButton(programFab1);
        programFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, programFab1.getLabelText(), Toast.LENGTH_SHORT).show();
            }
        });

        menu1.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu1.isOpened()) {
                    Toast.makeText(DashBoardActivity.this, menu1.getMenuButtonLabelText(), Toast.LENGTH_SHORT).show();
                }

                menu1.toggle(true);
            }
        });


        menus.add(menu1);
        menu1.hideMenuButton(false);


        int delay = 400;
        for (final com.github.clans.fab.FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }

        menu1.setClosedOnTouchOutside(true);
*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dash_board, menu);
        return true;
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(isNavDrawerOpen())
        {

        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


      //  mAdapter.getItem(0).setTargetFragment(Nati);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notifications) {

            Intent intent = new Intent(DashBoardActivity.this,MapActivity.class);
            intent.putExtra("yo",5);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public View getContainerToolbar() {
        return mContainerToolbar;
    }

    private void setupTabs() {
        mTabHost = (MaterialTabHost) findViewById(R.id.materialTabHost);
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        //when the page changes in the ViewPager, update the Tabs accordingly
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mTabHost.setSelectedNavigationItem(position);

            }
        });
        //Add all the Tabs to the TabHost
        for (int i = 0; i < mAdapter.getCount(); i++) {
            mTabHost.addTab(
                    mTabHost.newTab()
                            .setIcon(mAdapter.getIcon(i))
                            .setTabListener(this));
        }


    }

    private void setupDrawer() {

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("");
   /*   mToolbar=getActionBarToolbar();
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        mContainerToolbar = (ViewGroup) findViewById(R.id.container_app_bar);*/
        //set the Toolbar as ActionBar
/*
        setSupportActionBar(mToolbar);
*/
/*
        getSupportActionBar().setDisplayShowHomeEnabled(true);
*/
        //setup the NavigationDrawer
     /*   mDrawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
 */
    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {

        //when a Tab is selected, update the ViewPager to reflect the changes
        mPager.setCurrentItem(materialTab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {


    }



    private void setupFAB() {
        //define the icon for the main floating action button
        ImageView iconFAB = new ImageView(this);
        iconFAB.setImageResource(R.drawable.ic_action_new);

        //set the appropriate background for the main floating action button along with its icon
        mFAB = new FloatingActionButton.Builder(this)
                .setContentView(iconFAB)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        //define the icons for the sub action buttons
        ImageView iconSortName = new ImageView(this);
        iconSortName.setImageResource(R.drawable.ic_action_alphabets);
        ImageView iconSortDate = new ImageView(this);
        iconSortDate.setImageResource(R.drawable.ic_action_calendar);
        ImageView iconSortRatings = new ImageView(this);
        iconSortRatings.setImageResource(R.drawable.ic_action_important);

        //set the background for all the sub buttons
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        itemBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_sub_button_gray));


        //build the sub buttons
        SubActionButton buttonSortName = itemBuilder.setContentView(iconSortName).build();
        SubActionButton buttonSortDate = itemBuilder.setContentView(iconSortDate).build();
        SubActionButton buttonSortRatings = itemBuilder.setContentView(iconSortRatings).build();

        //to determine which button was clicked, set Tags on each button
        buttonSortName.setTag(TAG_SORT_NAME);
        buttonSortDate.setTag(TAG_SORT_DATE);
        buttonSortRatings.setTag(TAG_SORT_RATINGS);

        buttonSortName.setOnClickListener(this);
        buttonSortDate.setOnClickListener(this);
        buttonSortRatings.setOnClickListener(this);

        //add the sub buttons to the main floating action button
        mFABMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonSortName)
                .addSubActionView(buttonSortDate)
                .addSubActionView(buttonSortRatings)
                .attachTo(mFAB)
                .build();
    }

    private void toggleTranslateFAB(float slideOffset) {
        if (mFABMenu != null) {
            if (mFABMenu.isOpen()) {
                mFABMenu.close(true);
            }
            mFAB.setTranslationX(slideOffset * 200);
        }
    }

    @Override
    public void onClick(View v) {
        //call instantiate item since getItem may return null depending on whether the PagerAdapter is of type FragmentPagerAdapter or FragmentStatePagerAdapter
        Fragment fragment = (Fragment) mAdapter.instantiateItem(mPager, mPager.getCurrentItem());
        if (fragment instanceof SortListener) {

            if (v.getTag().equals(TAG_SORT_NAME)) {
                //call the sort by name method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByName();
            }
            if (v.getTag().equals(TAG_SORT_DATE)) {
                //call the sort by date method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByDate();
            }
            if (v.getTag().equals(TAG_SORT_RATINGS)) {
                //call the sort by ratings method on any Fragment that implements sortlistener
                ((SortListener) fragment).onSortByRating();
            }
        }
    }





/*
    private void createCustomAnimation() {
        final FloatingActionMenu menu3 = (FloatingActionMenu) findViewById(R.id.menu3);

        AnimatorSet set = new AnimatorSet();

        ObjectAnimator scaleOutX = ObjectAnimator.ofFloat(menu3.getMenuIconView(), "scaleX", 1.0f, 0.2f);
        ObjectAnimator scaleOutY = ObjectAnimator.ofFloat(menu3.getMenuIconView(), "scaleY", 1.0f, 0.2f);

        ObjectAnimator scaleInX = ObjectAnimator.ofFloat(menu3.getMenuIconView(), "scaleX", 0.2f, 1.0f);
        ObjectAnimator scaleInY = ObjectAnimator.ofFloat(menu3.getMenuIconView(), "scaleY", 0.2f, 1.0f);

        scaleOutX.setDuration(50);
        scaleOutY.setDuration(50);

        scaleInX.setDuration(150);
        scaleInY.setDuration(150);

        scaleInX.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                menu3.getMenuIconView().setImageResource(menu3.isOpened()
                        ? R.drawable.ic_close : R.drawable.ic_star);
            }
        });

        set.play(scaleOutX).with(scaleOutY);
        set.play(scaleInX).with(scaleInY).after(scaleOutX);
        set.setInterpolator(new OvershootInterpolator(2));

        menu3.setIconToggleAnimatorSet(set);
    }*/




    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        int icons[] = {R.drawable.ic_action_search,
                R.drawable.ic_action_trending,
                R.drawable.ic_action_upcoming,
                R.drawable.ic_action_upcoming,
                R.drawable.ic_action_upcoming};

        android.support.v4.app.FragmentManager fragmentManager;


        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
            fragmentManager = fm;
        }

        public Fragment getItem(int num) {
            Fragment fragment = null;
//            L.m("getItem called for " + num);
            switch (num) {
                case TAB_SEARCH_RESULTS:
                    fragment = RootFragment.newInstance(num);
                   /* if(DEFAULT.contentEquals("default")) {*/
/*
                        fragment =new RootFragment();
*/
                   /* }
                    if(DEFAULT.contentEquals("one"))
                    {
                        fragment = NativeGridGplayFragment.newInstance("", "");
                    }*/
                    break;
                case TAB_HITS:
                    fragment = FragmentBoxOffice.newInstance("", "");
                    break;
                case TAB_UPCOMING:
                    fragment = FragmentUpcoming.newInstance("", "");
                    break;
                case TAB_UPCOMING1:
                    fragment = RootFragment_three.newInstance("", "");
                    break;
                case TAB_UPCOMING2:
                    fragment = RootFragment_four.newInstance("", "");
                    break;
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getStringArray(R.array.tabs)[position];
        }

        private Drawable getIcon(int position) {
            return getResources().getDrawable(icons[position]);
        }
    }






}
