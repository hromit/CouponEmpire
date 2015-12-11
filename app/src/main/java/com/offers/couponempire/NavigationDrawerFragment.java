package com.offers.couponempire;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

        private RecyclerView recyclerView;


        public static final String PREF_FILE_NAME="testpref";
        public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";

        private ActionBarDrawerToggle mDrawerToggle;
        private DrawerLayout mDrawerLayout;
        private ViewAdapter adapter;

        private boolean mUserLearndDrawer;
        private boolean mFromSaveInstance;
        private View containerView;


    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    public List<Information> getData(){
        List<Information> data=new ArrayList<>();
        int[]icons={R.drawable.ic_launcher,R.drawable.ic_launcher,
                R.drawable.ic_launcher,R.drawable.ic_launcher};

        String[] tittels={"raju","raja","ammir","firoj"};
        for(int i=0;i<tittels.length &&i<icons.length;i++)
        {
            Information current=new Information();
            current.iconid=icons[i];
            current.tittle=tittels[i];
            data.add(current);
            Toast.makeText(getActivity(),"ddd"+current.iconid +"ff"+current.tittle,Toast.LENGTH_LONG).show();

        }
        return data;
    }



    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

          mUserLearndDrawer=   Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
         mUserLearndDrawer=Boolean.valueOf(false) ;
        if(saveInstanceState!=null){
            mFromSaveInstance=true;
        }



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout=inflater.inflate(R.layout.fragment_navigation_drawer,container,false);
        recyclerView=(RecyclerView) layout.findViewById(R.id.drawerList);
        adapter=new ViewAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }



    public void setUp(int fragmentid , DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView=getActivity().findViewById(fragmentid);
        mDrawerLayout=drawerLayout;
        mDrawerToggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                if(!mUserLearndDrawer){
                    mUserLearndDrawer=true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearndDrawer+"");
                }
                getActivity().invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getActivity().invalidateOptionsMenu();

                super.onDrawerClosed(drawerView);
                }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.6)
             toolbar.setAlpha(1-slideOffset);
            }
        };
        if(!mUserLearndDrawer && !mFromSaveInstance){
            mDrawerLayout.openDrawer(containerView);

        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });


    }
    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue ){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(preferenceName ,preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defoultValue ) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName,defoultValue);


    }
}
