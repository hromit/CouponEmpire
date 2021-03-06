package com.offers.couponempire;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_appbar);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        NavigationDrawerFragment drawerFragment=(NavigationDrawerFragment)getFragmentManager().findFragmentById(R.id.fragement_nav_drawer);

        drawerFragment.setUp(R.id.fragement_nav_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this ,"hey you just hit"+item.getTitle(),Toast.LENGTH_SHORT).show();


            return true;
        }
        {
            if(id==R.id.navigate){
               startActivity(new Intent(this,SubActivity.class));
            }

        }


        return super.onOptionsItemSelected(item);
    }
}
