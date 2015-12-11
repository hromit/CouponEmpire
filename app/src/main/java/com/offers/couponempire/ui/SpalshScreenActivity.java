package com.offers.couponempire.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.offers.couponempire.MainActivity;
import com.offers.couponempire.R;
import com.offers.couponempire.animations.CustomAnimation;
import com.offers.couponempire.utils.CommonUtils;
import com.vijay.jsonwizard.activities.JsonFormActivity;


public class SpalshScreenActivity extends Activity {


    private static final int    REQUEST_CODE_GET_JSON = 1;
    private static final String TAG                   = "SplashActivity";
    private static final String DATA_JSON_PATH        = "data.json";



   // private String TAG = "** GCMPushDEMOAndroid**";
    private TextView mDisplay;
    String regId = "";

    boolean isAppInstalled = false;
    String urll,url2;

    String android_id;
    String deviceName;
    String deviceMan;
    String version;
    String device;

    public SharedPreferences sharedPreferences;

    //Set time
    private static int splashInterval = 5000;
    boolean showingMainActivityScheduled = false;

    Handler handler;

	   public void onAttachedToWindow() {
			super.onAttachedToWindow();
			Window window = getWindow();
			window.setFormat(PixelFormat.RGBA_8888);

		}
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);

        sharedPreferences.getBoolean("issignedin",false);

       /* SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("issignedin",false);
        editor.commit();*/

        Toast.makeText(getBaseContext(),"ss"+sharedPreferences.getBoolean("issignedin",true),Toast.LENGTH_LONG).show();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

		/*
		 * Showing splashscreen while making network calls to download necessary
		 * data before launching the app Will use AsyncTask to make http call
		 */

        setContentView(R.layout.activity_splash);

        StartAnimations();

    }


    @Override
    public void onResume() {
        super.onResume();

        this.registerReceiver(this.mConnReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }




    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mConnReceiver);
    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);
        
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);
        
        
        
    }


   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GET_JSON && resultCode == RESULT_OK) {
            Log.d(TAG, data.getStringExtra("json"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/



    private BroadcastReceiver mConnReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            String reason = intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
            boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);

            NetworkInfo currentNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            NetworkInfo otherNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_OTHER_NETWORK_INFO);

            if(currentNetworkInfo.isConnected()){

                isAppInstalled = sharedPreferences.getBoolean("isAppInstalled",false);
                Log.d("shortcut test", "shortcut" + isAppInstalled);
                if(!isAppInstalled)
                {
                    addShortcut();
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isAppInstalled", true);
                Boolean t = (Boolean) getLastNonConfigurationInstance();
                if (t != null) {
                    showingMainActivityScheduled = t.booleanValue();
                }

                if (!showingMainActivityScheduled) {
                    showingMainActivityScheduled = true;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(SpalshScreenActivity.this, CustomAnimation.class);
                            startActivity(intent);
                            finish();

                          /*  Intent intent = new Intent(SpalshScreenActivity.this, JsonFormActivity.class);
                            String json = CommonUtils.loadJSONFromAsset(getApplicationContext(), DATA_JSON_PATH);
                            intent.putExtra("json", json);
                            startActivityForResult(intent, REQUEST_CODE_GET_JSON);
                            finish();*/
                        }
                    }, splashInterval);
                }

            }else{

                Toast mytoast= Toast.makeText(getApplicationContext(),
                        "No Internet Connection", Toast.LENGTH_LONG);
                mytoast.show();
                Intent i = new Intent(SpalshScreenActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }
    };













    private void addShortcut() {
        //Adding shortcut for MainActivity
        //on Home screen
        Intent shortcutIntent = new Intent(getApplicationContext(),
                SpalshScreenActivity.class);

        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME,"Coupon Empire");
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                        R.drawable.ic_launcher));

        addIntent
                .setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        getApplicationContext().sendBroadcast(addIntent);
    }





}