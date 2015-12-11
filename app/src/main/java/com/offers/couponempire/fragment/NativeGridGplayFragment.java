/*
 * ******************************************************************************
 *   Copyright (c) 2013-2014 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */

package com.offers.couponempire.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.offers.couponempire.R;
import com.offers.couponempire.ui.CouponsByCategorieActivity;

import java.util.ArrayList;

//import com.example.piro.mohallasmarket.ui.DetailedScreenActivity;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;

/**
 * Grid as Google Play example
 *
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class NativeGridGplayFragment extends BaseMaterialFragment implements FragmentChangeListener{

    protected ScrollView mScrollView;
 //   DataModel ddd = DataModel.getInstance();
    boolean isPlaying = false;
//   ImageButton playButton;
//   ProgressBar progressBar;
   /* private MediaPlayer mp;*/
/*
    public Toolbar actionBar;
*/

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    FloatingActionMenu menu2;

    private FloatingActionButton fab12;
    private FloatingActionButton fab22;
    private FloatingActionButton fab32;

    public SharedPreferences sharedPreferences;
    /*Typeface typeface;*/


  /*  @Override
    protected int getSubTitleHeaderResourceId() {
        return R.string.header_title_subtitle_ggplay;
    }

    @Override
    protected int getTitleHeaderResourceId() {
        return R.string.header_title_group3;
    }

    @Override
    protected String getDocUrl() {
        return "https://play.google.com/store/apps/details?id=com.stratoshear.candyapps&hl=en";
    }

    @Override
    protected String getSourceUrl() {
        return "https://play.google.com/store/apps/details?id=com.stratoshear.candyapps&hl=en";
    }*/

    static FragmentChangeListener firstChangeListener;

    public static NativeGridGplayFragment newInstance(String param1, String param2,FragmentChangeListener fragmentChangeListener) {
        NativeGridGplayFragment fragment = new NativeGridGplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        firstChangeListener=fragmentChangeListener;
        fragment.setArguments(args);
        return fragment;
    }
/*
    @Override
    public int getTitleResourceId() {
        return R.string.carddemo_title_grid_gplay;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        sharedPreferences.getString("action_bar_view_count","1");
     /*
        actionBar = (Toolbar) getActivity().findViewById(R.id.toolbar_actionbar);
        actionBar.setBackgroundColor(getResources().getColor(R.color.demo_primary_color));*/


/*
        actionBar.setTitleTextColor(getResources().getColor(android.R.color.white));
*/

        
        return inflater.inflate(R.layout.demo_fragment_native_grid_gplay, container, false);
        
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fab12 = (FloatingActionButton) getActivity().findViewById(R.id.fab12);
        fab22 = (FloatingActionButton) getActivity().findViewById(R.id.fab22);
        fab32 = (FloatingActionButton) getActivity().findViewById(R.id.fab32);
        menu2 = (FloatingActionMenu) getActivity().findViewById(R.id.menu2);

        initCards();
        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();
		/*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
                transaction.replace(R.id.root_frame, new NativeGridGplayFragment());

                transaction.commit();
            }
        });

        fab32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();
		/*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
                transaction.replace(R.id.root_frame, new NativeRecyclerViewMaterialCardFragment());

                transaction.commit();
            }
        });

        menu2.setClosedOnTouchOutside(true);

    //    playButton = (ImageButton) getActivity().findViewById(R.id.bar_button_source);
       /* playButton.setBackgroundResource(android.R.drawable.ic_media_play);*/
     //   progressBar =(ProgressBar) getActivity().findViewById(R.id.progressBarr);
    }


    private void initCards() {

        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i <100; i++) {

            GplayGridCard card = new GplayGridCard(getActivity());




            try {
/*
                card.headerTitle = "Retailer"+Integer.toString(i+1) ;
*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                card.mSecondaryTitle = "card secondary title"+Integer.toString(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            card.rating = (float) (Math.random() * (5.0));

            //Only for test, change some icons

            try {
               /* card.resourceIdThumbnailUrl=ddd.getCampaignListBytagname().get("Ads").get(i).getString("bannerurl").toString();
                card.playUrl=ddd.getCampaignListBytagname().get("Ads").get(i).getString("file_path").toString();
*/
          
            } catch (Exception e) {
                e.printStackTrace();
            }
           /* if ((i % 6 == 0)) {
                card.resourceIdThumbnail = R.drawable.ic_ic_dh_bat;
            } else if ((i % 6 == 1)) {
                card.resourceIdThumbnail = R.drawable.ic_ic_dh_net;
            } else if ((i % 6 == 2)) {
                card.resourceIdThumbnail = R.drawable.ic_tris;
            } else if ((i % 6 == 3)) {
                card.resourceIdThumbnail = R.drawable.ic_info;
            } else if ((i % 6 == 4)) {
                card.resourceIdThumbnail = R.drawable.ic_smile;
            }*/

            card.init();
            cards.add(card);
        }

        CardGridArrayAdapter mCardArrayAdapter = new CardGridArrayAdapter(getActivity(), cards);

        CardGridView listView = (CardGridView) getActivity().findViewById(R.id.carddemo_grid_base1);
        if (listView != null) {
            listView.setAdapter(mCardArrayAdapter);
        }
    }

    @Override
    public void onSwitchToNextFragment() {

    }


    public class GplayGridCard extends Card {

        protected TextView mTitle;
        protected String mSecondaryTitle;
        protected RatingBar mRatingBar;
        protected int resourceIdThumbnail = 1;
       /* protected String resourceIdThumbnailUrl;
        protected String playUrl;*/


        protected int count;

        protected String headerTitle;
      /*  protected String secondaryTitle;*/
        protected float rating;

        public GplayGridCard(Context context) {
            super(context, R.layout.carddemo_native_gplay_inner_content);
        }

        public GplayGridCard(Context context, int innerLayout) {
            super(context, innerLayout);
        }

        private void init() {
            CardHeader header = new CardHeader(getContext(),R.layout.native_inner_gplay_header);
             /*TextView ffff = (TextView) getContext().findViewById(R.id.card_header_inner_simple_title);
           Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
             ffff.setTypeface(typeface);*/
            header.setButtonOverflowVisible(true);

            header.setTitle(headerTitle);
           /* header.setPopupMenu(R.menu.popupmain, new CardHeader.OnClickCardHeaderPopupMenuListener() {
                @Override
                public void onMenuItemClick(BaseCard card, MenuItem item) {
                    if(item.getTitle().toString().contentEquals("Subscribe"))
                    {
                        Utils.Subscribe(getActivity());
                        
                    }
                    if(item.getTitle().toString().contentEquals("Rate"))
                    {
                       // Toast.makeText(getContext(), "Item " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        Utils.Rate(getActivity());
                    }
                    if(item.getTitle().toString().contentEquals("Share"))
                    {
                        // Toast.makeText(getContext(), "Item " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        Utils.Share(getActivity());
                    }

                    }

            });*/

            addCardHeader(header);

            GplayGridThumb thumbnail = new GplayGridThumb(getContext());
            if (resourceIdThumbnail > -1)
                thumbnail.setDrawableResource(R.drawable.rsz_paytm);
            else
                thumbnail.setDrawableResource(R.drawable.grid_ic);

           addCardThumbnail(thumbnail);

            
            
            
           setOnClickListener(new OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {



                    Intent i = new Intent(getContext(),CouponsByCategorieActivity.class);
/*
                    i.putExtra("message", headerTitle);
                    i.putExtra("description",mSecondaryTitle);
                    i.putExtra("bannerurl",resourceIdThumbnailUrl);
                    i.putExtra("playurl",playUrl);*/
                    startActivity(i);



/*

                    Intent i = new Intent(getContext(),DetailedScreenActivity.class);

                    i.putExtra("message", headerTitle);
                    i.putExtra("description",mSecondaryTitle);
                    i.putExtra("bannerurl",resourceIdThumbnailUrl);
                    i.putExtra("playurl",playUrl);
                   startActivity(i);
*/

/*
                    getLPreviewUtils().startActivityWithTransition(
                            i,
                            clickedView,
                            NativeDashFragment.VIEW_COLOR
                    );  */
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    

                 /*   DisplayMetrics displaymetrics = new DisplayMetrics();
                    getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                    int heightt = displaymetrics.heightPixels;
                    int widthh = displaymetrics.widthPixels;
                    */
                    
                  /*  final Toolbar actionBarr = (Toolbar) getActivity().findViewById(R.id.toolbar_actionbar);

                    actionBarr.getLayoutParams().width=(heightt+200)/2;
                    actionBarr.getLayoutParams().height=(heightt+200)/2;*/

                /*    Picasso.with(getActivity()).load(resourceIdThumbnailUrl).resize((heightt+200)/2,(heightt+200)/2).into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                            BitmapDrawable ob = new BitmapDrawable(getResources(), bitmap);

                            LinearLayout  linearLayout=  (LinearLayout) getActivity().findViewById(R.id.headerbar);
                            linearLayout.setBackgroundDrawable(ob);

                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {

                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {

                        }
                    });
                   actionBar.setBackgroundColor(getResources().getColor(android.R.color.transparent));*/
                    
            /*       LinearLayout ff = (LinearLayout) getActivity().findViewById(R.id.ooo);
                    actionBar.addView(ff);*/

                   
                    //Do something
                 /*   Toast.makeText(getActivity(), " Click on ActionArea ", Toast.LENGTH_SHORT).show();*/
                 /*   BaseFragment baseFragment;
                    try {
                        Class<? extends BaseFragment> mClass = NativeMaterialCardFragment.class;
                        baseFragment = mClass.newInstance();

                    } catch (Exception e) {
                        throw new IllegalStateException("Could not load Fragment from class: " + NativeMaterialCardFragment.class.getName(), e);
                    }
                
                    FragmentManager fragmentManager = (getActivity()).getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, baseFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();*/
                  /* TextView player_text = (TextView) getActivity().findViewById(R.id.song_tile);*/
                 /*  
                   TextView mTitleHeader = (TextView) getActivity().findViewById(R.id.header_title);
                    mTitleHeader.setText(headerTitle);
                    play(getActivity(), playUrl);*/

                   /* BaseFragment baseFragment;
                    Bundle bundle=new Bundle();
                    bundle.putString("message", headerTitle);
                    bundle.putString("bannerurl",resourceIdThumbnailUrl);
                    bundle.putString("playurl",playUrl);
                    try {
                        Class<? extends BaseFragment> mClass = NativeCardFragment.class;
                        baseFragment = mClass.newInstance();
                        baseFragment.setArguments(bundle);

                    } catch (Exception e) {
                        throw new IllegalStateException("Could not load Fragment from class: " + NativeCardFragment.class.getName(), e);
                    }

                    FragmentManager fragmentManager = (getActivity()).getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // fragmentTransaction.replace(R.id.container, baseFragment);
                    fragmentTransaction.replace(R.id.container,baseFragment,"grid_pane1");
                    fragmentTransaction.addToBackStack("grid_pane");
                    fragmentTransaction.commit();*/

                }
            });
        }

        @Override
        public void setupInnerViewElements(ViewGroup parent, View view) {

            TextView title = (TextView) view.findViewById(R.id.carddemo_gplay_main_inner_title);
            title.setText("4 Offers");

          /*  Button subtitle = (Button) view.findViewById(R.id.carddemo_gplay_main_inner_subtitle);
            subtitle.setText(secondaryTitle);*/
           /* subtitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playButton.setImageResource(android.R.drawable.ic_media_play);
                    BaseFragment baseFragment;
                    Bundle bundle=new Bundle();
                    bundle.putString("message", headerTitle);
                    bundle.putString("bannerurl",resourceIdThumbnailUrl);
                    bundle.putString("playurl",playUrl);
                    try {
                       Class<? extends BaseFragment> mClass = NativeCardFragment.class;
                       baseFragment = mClass.newInstance();
                       baseFragment.setArguments(bundle);

                    } catch (Exception e) {
                        throw new IllegalStateException("Could not load Fragment from class: " + NativeCardFragment.class.getName(), e);
                    }

                    FragmentManager fragmentManager = (getActivity()).getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    
                   // fragmentTransaction.replace(R.id.container, baseFragment);
                    fragmentTransaction.replace(R.id.container,baseFragment,"grid_pane1");
                    fragmentTransaction.addToBackStack("grid_pane");
                    fragmentTransaction.commit();
                    
                }
            });*/

         /*   RatingBar mRatingBar = (RatingBar) parent.findViewById(R.id.carddemo_gplay_main_inner_ratingBar);

            mRatingBar.setNumStars(5);
            mRatingBar.setMax(5);
            mRatingBar.setStepSize(0.5f);
            mRatingBar.setRating(rating);*/
        }

        class GplayGridThumb extends CardThumbnail {

            public GplayGridThumb(Context context) {
                super(context);
            }


            @Override
            public void setupInnerViewElements(ViewGroup parent, View viewImage) {

               /*if (viewImage != null) {

                    if (parent!=null && parent.getResources()!=null){
                        DisplayMetrics metrics=parent.getResources().getDisplayMetrics();

                        int base = 125;

                        if (metrics!=null){
                            viewImage.getLayoutParams().width = (int)(base*metrics.density);
                            viewImage.getLayoutParams().height = (int)(base*metrics.density);
                        }else{
                            viewImage.getLayoutParams().width = 250;
                            viewImage.getLayoutParams().height = 250;
                        }
                    }
                }*/
              
             /*   viewImage.getLayoutParams().width = 240;
                viewImage.getLayoutParams().height = 240;
                viewImage.setPadding(0,0,0,0);*/

                DisplayMetrics displaymetrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int heightt = displaymetrics.heightPixels;
                int widthh = displaymetrics.widthPixels;


            /*    v.add();*/
                
               final float g =6;
                /*Picasso.with(getActivity())
                        .load(resourceIdThumbnailUrl)
                        .resize(180,180)
                        .error(R.drawable.ic_error_loadingsmall)
                        .into((ImageView) viewImage);*/


            }
        }

    }

    
}
