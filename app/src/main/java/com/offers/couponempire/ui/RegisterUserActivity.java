package com.offers.couponempire.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.offers.couponempire.R;
import com.offers.couponempire.utils.CommonUtils;
import com.vijay.jsonwizard.activities.JsonFormActivity;

public class RegisterUserActivity extends AppCompatActivity {

    private static final int    REQUEST_CODE_GET_JSON = 1;
    private static final String TAG                   = "SplashActivity";
    private static final String DATA_JSON_PATH        = "data.json";


    Button sign_up, sign_in;
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        //issignedin=  sharedPreferences.getBoolean("issignedin",false);

       /* SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("issignedin",false);
        editor.commit();*/

        sign_up=(Button) findViewById(R.id.fbv);
        sign_in=(Button) findViewById(R.id.googlev);
        TextView textView = (TextView) findViewById(R.id.skip);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), DashBoardActivity.class);
                startActivity(intent);
                finish();;
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterUserActivity.this, JsonFormActivity.class);
                String json = CommonUtils.loadJSONFromAsset(getApplicationContext(), DATA_JSON_PATH);
                intent.putExtra("json", json);
                startActivityForResult(intent, REQUEST_CODE_GET_JSON);
               /* finish();*/
            }
        });


        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("issignedin",true);
                editor.commit();

                Toast.makeText(getBaseContext(),"Successfully Signed In",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(), DashBoardActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_user, menu);
        return true;
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GET_JSON && resultCode == RESULT_OK) {
            Log.d(TAG, data.getStringExtra("json"));
        }
        super.onActivityResult(requestCode, resultCode, data);
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
