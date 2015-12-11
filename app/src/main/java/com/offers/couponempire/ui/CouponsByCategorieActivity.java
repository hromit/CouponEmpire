package com.offers.couponempire.ui;

import android.database.DataSetObserver;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.offers.couponempire.R;

import java.util.ArrayList;
import java.util.List;

public class CouponsByCategorieActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mActionBarToolbar;
/*
    private SampleSpinnerAdapter mSpinnerAdapter = new SampleSpinnerAdapter();
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons_by_categories);
        getActionBarToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        setUpActionBarSpinner();
    }

    private List<String> getMyObjectSpinnerData() {

        List<String> dd= new ArrayList<>();
        dd.add("Rwcharge");
        dd.add("Mobile & Tablets");
        dd.add("Fashion");
        dd.add("Food & Dining");
        dd.add("Computers, Laptops & Gaming");
        dd.add("Home Furnishing & Decor");
        dd.add("Travel");
        dd.add("Beauty & Health");
        dd.add("Kids, Babies & Toys");
        dd.add("Flower, Gifts & Jewellery");
        dd.add("TV,  Audio/Video & Movies");
        dd.add("Appliances");
        dd.add("Cameras & Accessories");
        dd.add("Books & Stationery");
        dd.add("Sports & Fitness");
        dd.add("Education & Learning");
        dd.add("Entertainment");
        dd.add("Web HOsting & Domains");
        dd.add("Miscellaneous");
        dd.add("Automotive");
        dd.add("Adult");




        return dd;


    }

    private void setUpActionBarSpinner() {


        Toolbar toolbar = getActionBarToolbar();

        View spinnerContainer = LayoutInflater.from(this).inflate(R.layout.toolbar_spinner,
                toolbar, false);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        toolbar.addView(spinnerContainer, lp);

        YourObjectSpinnerAdapter spinnerAdapter = new YourObjectSpinnerAdapter();
        spinnerAdapter.addItems(getMyObjectSpinnerData());

        Spinner spinner = (Spinner) spinnerContainer.findViewById(R.id.toolbar_spinner);
        spinner.setAdapter(spinnerAdapter);



       /* android.support.v7.widget.Toolbar toolbar = getActionBarToolbar();

        Spinner spinner = (Spinner) LayoutInflater.from(this).inflate(R.layout.actionbar_spinner,toolbar, false);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.addView(spinner, lp);

        spinner.setAdapter(mSpinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> spinner, View view, int position, long itemId) {
                Toast.makeText(CouponsByCategorieActivity.this, "Selected: " + mSpinnerAdapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });*/
    }



    private class YourObjectSpinnerAdapter extends BaseAdapter {
        private List<String> mItems = new ArrayList<>();

        public void clear() {
            mItems.clear();
        }

        public void addItem(String yourObject) {
            mItems.add(yourObject);
        }

        public void addItems(List<String> yourObjectList) {
            mItems.addAll(yourObjectList);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getDropDownView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
                view = getLayoutInflater().inflate(R.layout.toolbar_spinner_item_dropdown, parent, false);
                view.setTag("DROPDOWN");
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getTitle(position));

            return view;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")) {
                view = getLayoutInflater().inflate(R.layout.
                        toolbar_spinner_item_actionbar, parent, false);
                view.setTag("NON_DROPDOWN");
            }
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getTitle(position));
            return view;
        }

        private String getTitle(int position) {
            return position >= 0 && position < mItems.size() ? mItems.get(position) : "";
        }
    }




  /*  private class SampleSpinnerAdapter implements SpinnerAdapter {
        @Override
        public View getDropDownView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
                view = getLayoutInflater().inflate(R.layout.spinner_item_dropdown, parent, false);
                view.setTag("DROPDOWN");
            }
            ((TextView) view).setText(getItem(position).toString());
            return view;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")) {
                view = getLayoutInflater().inflate(R.layout.spinner_item_actionbar, parent, false);
                view.setTag("NON_DROPDOWN");
            }
            ((TextView) view).setText(getItem(position).toString());
            return view;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int i) {
            return "Spinner item " + (i + 1);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public int getItemViewType(int i) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
*/
    protected android.support.v7.widget.Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_action);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coupons_by_brands, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
