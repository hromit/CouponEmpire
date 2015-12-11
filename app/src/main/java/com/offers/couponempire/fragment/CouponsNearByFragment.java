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

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.offers.couponempire.R;
import com.offers.couponempire.ui.CouponDetailOnlineActivity;
import com.offers.couponempire.ui.CouponDetailOfflineActivity;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;


/**
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class CouponsNearByFragment extends BaseNativeListFragment {

    CardArrayRecyclerViewAdapter mCardArrayAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    FloatingActionMenu menu2;

    private FloatingActionButton fab12;
    private FloatingActionButton fab22;
    private FloatingActionButton fab32;

    ImageView imageView;
    boolean isvisible=true;
/*
    CardRecyclerView cardRecyclerView;
*/

    ImageButton t4;
    int count=0;
    int i;




/*
    @Override
    protected int getSubTitleHeaderResourceId() {
        return R.string.header_title_subtitle_recyclerview;
    }

    @Override
    protected int getTitleHeaderResourceId() {
        return R.string.header_title_group3;
    }

    @Override
    protected String getDocUrl() {
        return "https://github.com/gabrielemariotti/cardslib/blob/master/doc/RECYCLERVIEW.md";
    }

    @Override
    protected String getSourceUrl() {
        return "https://github.com/gabrielemariotti/cardslib/blob/master/demo/stock/src/main/java/it/gmariotti/cardslib/demo/fragment/nativeview/NativeRecyclerViewFragment.java";
    }*/

/*
    public static NativeRecyclerViewMaterialCardFragment newInstance(String param1, String param2) {
        NativeRecyclerViewMaterialCardFragment fragment = new NativeRecyclerViewMaterialCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    public CouponsNearByFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_coupons_near_by, container, false);


       /* try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        // Perform any camera updates here
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hideList(false);
        fab12 = (FloatingActionButton) getActivity().findViewById(R.id.fab12);
        fab22 = (FloatingActionButton) getActivity().findViewById(R.id.fab22);
        fab32 = (FloatingActionButton) getActivity().findViewById(R.id.fab32);

        imageView =(ImageView) getActivity().findViewById(R.id.card_overlay_image);

        menu2 = (FloatingActionMenu) getActivity().findViewById(R.id.menu2);
        //Set the arrayAdapter
        ArrayList<Card> cards = new ArrayList<Card>();

        Toast.makeText(getActivity().getBaseContext(),"s"+ cards.size(),Toast.LENGTH_LONG).show();

        mCardArrayAdapter = new CardArrayRecyclerViewAdapter(getActivity(), cards);


        //Staggered grid view
        final CardRecyclerView mRecyclerView = (CardRecyclerView) getActivity().findViewById(R.id.carddemo_recyclerview3);
        mRecyclerView.setHasFixedSize(false);

    //    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

   //     int position = layoutManager.f

      //  int position = mRecyclerView.getLayoutManager().findFirstVisibleItemPositions(null)[0];

        //Set the empty view
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mCardArrayAdapter);
        }

        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction    transaction = getFragmentManager()
                        .beginTransaction();
		/*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
                transaction.replace(R.id.root_frame_four, new NativeGridGplayFragment());

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
                transaction.replace(R.id.root_frame_four, new CouponsNearByFragment());

                transaction.commit();
            }
        });

        menu2.setClosedOnTouchOutside(true);


        t4= (ImageButton) getActivity().findViewById(R.id.t4);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



               /* transaction.replace(R.id.root_frame_four, new MapFragment());

                transaction.commit();
*/
                if (isvisible) {

                    isvisible = false;
                    FragmentTransaction transaction = getFragmentManager()
                            .beginTransaction();
                    transaction.replace(R.id.root_frame_four, new MapFragment());
                    transaction.commit();


                }
                else
                {
                    isvisible = true;
                    FragmentTransaction transaction = getFragmentManager()
                            .beginTransaction();
                    transaction.replace(R.id.root_frame_four, new CouponsNearByFragment());

                    transaction.commit();


                }


               /* if (isvisible) {




                }
                if (!isvisible) {

                    transaction.replace(R.id.root_frame_four, new CouponsNearByFragment());

                    transaction.commit();
                    isvisible = true;

                }
*/

            }
        });


        new LoaderAsyncTask().execute();
    }


    //-------------------------------------------------------------------------------------------------------------
    // Images loader
    //-------------------------------------------------------------------------------------------------------------
    /**
     * Async Task to elaborate images
     */
    class LoaderAsyncTask extends AsyncTask<Void, Void, ArrayList<Card>> {

        LoaderAsyncTask() {
        }

        @Override
        protected ArrayList<Card> doInBackground(Void... params) {
            //elaborate images
            SystemClock.sleep(1000); //delay to simulate download, don't use it in a real app
            if (isAdded()) {
                ArrayList<Card> cards = initCard();
                return cards;
            }else
                return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Card> cards) {
            //Update the adapter
            updateAdapter(cards);
            displayList();
        }
    }


    /**
     * This method builds a simple list of cards
     */
    private ArrayList<Card> initCard() {

        //Init an array of Cards
        ArrayList<Card> cards = new ArrayList<Card>();
        for ( i = 0; i < 13; i++) {
            ArrayList<BaseSupplementalAction> actions = new ArrayList<BaseSupplementalAction>();

            // Set supplemental actions
        /*    TextSupplementalAction t1 = new TextSupplementalAction(getActivity(), R.id.text1);
            t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getActivity()," Click on Text SHARE "+card.getTitle(),Toast.LENGTH_SHORT).show();
                }
            });
            actions.add(t1);

            TextSupplementalAction t2 = new TextSupplementalAction(getActivity(), R.id.text2);
            t2.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getActivity()," Click on Text LEARN "+card.getTitle(),Toast.LENGTH_SHORT).show();
                }
            });
            actions.add(t2);*/

            CardHeader cardHeader = new CardHeader(getActivity().getBaseContext());
            cardHeader.setTitle("yooooooo");

           /* if(i==1)
            {
                imageView.setImageResource(R.drawable.rsz_jacknjones);
            }*/


            //Create a Card, set the title over the image and set the thumbnail
            MaterialLargeImageCard card =
                    MaterialLargeImageCard.with(getActivity())
                            .setTitle("a"+i)
                            .setTextOverImage("Italian Beaches " + i)
                            .useDrawableId(R.drawable.sea)
                            .build();

            card.addCardHeader(cardHeader);
            card.setOnClickListener(new Card.OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {


                 /*   if (i == 0) {



                    }*/


                    if (card.getTitle().contentEquals("a1")) {
                        Intent intent = new Intent(getActivity().getBaseContext(), CouponDetailOfflineActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getActivity().getBaseContext(), CouponDetailOnlineActivity.class);
                        startActivity(intent);
                    }
                }
            });

            cards.add(card);
        }

        return cards;
    }

    /**
     * Update the adapter
     */
    private void updateAdapter(ArrayList<Card> cards) {

        if (cards != null) {
            mCardArrayAdapter.addAll(cards);
         //   Toast.makeText(getActivity().getBaseContext(),"aaa"+mCardArrayAdapter.getItem(0),Toast.LENGTH_LONG).show();;

        }
    }




}
