package com.offers.couponempire.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.offers.couponempire.R;
import com.offers.couponempire.ui.CouponDetailOfflineActivity;
import com.offers.couponempire.ui.CouponDetailOnlineActivity;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;


public class MyWalletFragment extends BaseNativeListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    CardArrayRecyclerViewAdapter mCardArrayAdapter;

    /*  FloatingActionMenu menu2;

      private FloatingActionButton fab12;
      private FloatingActionButton fab22;
      private FloatingActionButton fab32;
  */
    ImageView imageView;

    int count=0;
    int i;

    // TODO: Rename and change types and number of parameters
    public static MyWalletFragment newInstance(String param1, String param2) {
        MyWalletFragment fragment = new MyWalletFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MyWalletFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_wallet, container, false);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hideList(false);
      /*  fab12 = (FloatingActionButton) getActivity().findViewById(R.id.fab12);
        fab22 = (FloatingActionButton) getActivity().findViewById(R.id.fab22);
        fab32 = (FloatingActionButton) getActivity().findViewById(R.id.fab32);
*/
        imageView =(ImageView) getActivity().findViewById(R.id.card_overlay_image);

/*
        menu2 = (FloatingActionMenu) getActivity().findViewById(R.id.menu2);
*/
        //Set the arrayAdapter
        ArrayList<Card> cards = new ArrayList<Card>();
        Toast.makeText(getActivity().getBaseContext(), "s" + cards.size(), Toast.LENGTH_LONG).show();

        mCardArrayAdapter = new CardArrayRecyclerViewAdapter(getActivity(), cards);


        //Staggered grid view
        CardRecyclerView mRecyclerView = (CardRecyclerView) getActivity().findViewById(R.id.carddemo_recyclerview2);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Set the empty view
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mCardArrayAdapter);
        }
/*
        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();
		*//*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 *//*
                transaction.replace(R.id.root_frame, new NativeGridGplayFragment());

                transaction.commit();
            }
        });

        fab32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();
		*//*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 *//*
                transaction.replace(R.id.root_frame, new CouponsNearByFragment());

                transaction.commit();
            }
        });

        menu2.setClosedOnTouchOutside(true);*/

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
        }
    }





}
