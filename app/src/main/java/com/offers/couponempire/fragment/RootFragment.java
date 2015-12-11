package com.offers.couponempire.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.offers.couponempire.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link } interface
 * to handle interaction events.
 * Use the {@link RootFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RootFragment extends BaseMaterialFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FloatingActionMenu menu2;

    private FloatingActionButton fab12;
    private FloatingActionButton fab22;
    private FloatingActionButton fab32;

    FragmentTransaction transaction;


    private static final String TAG = "RootFragment";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment RootFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RootFragment newInstance(int position) {
        RootFragment fragment = new RootFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    public RootFragment() {
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
        View view =inflater.inflate(R.layout.fragment_root, container, false);
        transaction = getChildFragmentManager()
                .beginTransaction();
		/*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
        transaction.replace(R.id.root_frame, new NativeRecyclerViewMaterialCardFragment());

        transaction.commit();
     /*   fab12 = (FloatingActionButton) getActivity().findViewById(R.id.fab12);
        fab22 = (FloatingActionButton) getActivity().findViewById(R.id.fab22);
        fab32 = (FloatingActionButton) getActivity().findViewById(R.id.fab32);

        menu2 = (FloatingActionMenu) getActivity().findViewById(R.id.menu2);

        fab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transaction.replace(R.id.root_frame, new NativeGridGplayFragment());

                transaction.commit();
            }
        });

        menu2.setClosedOnTouchOutside(true);
*/
        return view;
    }


}
