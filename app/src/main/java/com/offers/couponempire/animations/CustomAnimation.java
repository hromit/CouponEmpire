package com.offers.couponempire.animations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.offers.couponempire.R;
import com.offers.couponempire.slides.FifthSlide;
import com.offers.couponempire.slides.FirstSlide;
import com.offers.couponempire.slides.FourthSlide;
import com.offers.couponempire.slides.SecondSlide;
import com.offers.couponempire.slides.SeventhSlide;
import com.offers.couponempire.slides.SixthSlide;
import com.offers.couponempire.slides.ThirdSlide;

import com.offers.couponempire.ui.RegisterUserActivity;
import com.offers.couponempire.utils.CommonUtils;
import com.vijay.jsonwizard.activities.JsonFormActivity;

public class CustomAnimation extends AppIntro {

    private static final int    REQUEST_CODE_GET_JSON = 1;
    private static final String TAG                   = "SplashActivity";
    private static final String DATA_JSON_PATH        = "data.json";


    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(new FirstSlide());
        addSlide(new SecondSlide());
        addSlide(new ThirdSlide());
        addSlide(new FourthSlide());
        addSlide(new FifthSlide());
        addSlide(new SixthSlide());
        addSlide(new SeventhSlide());

        setCustomTransformer(new ZoomOutPageTransformer());
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, RegisterUserActivity.class);
      /*  String json = CommonUtils.loadJSONFromAsset(getApplicationContext(), DATA_JSON_PATH);
        intent.putExtra("json", json);
        startActivityForResult(intent, REQUEST_CODE_GET_JSON);*/
        startActivity(intent);
        finish();
    }



    @Override
    public void onSkipPressed() {
        loadMainActivity();
/*
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
*/
    }




  /*  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GET_JSON && resultCode == RESULT_OK) {
            Log.d(TAG, data.getStringExtra("json"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/


    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    public void getStarted(View v){
        loadMainActivity();
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}