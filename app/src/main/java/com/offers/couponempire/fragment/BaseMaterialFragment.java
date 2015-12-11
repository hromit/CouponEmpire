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
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public abstract class BaseMaterialFragment extends BaseFragment {

   /* private View mHeaderBox;
    private View mHeaderContentBox;
    private View mHeaderBackgroundBox;
    private View mHeaderShadow;

    TextView mTitleHeader;
    TextView mSubTitleHeader;

    ImageButton mSourceButton;
    ImageButton mDocButton;
*/
    private int colorResId = -1;

    boolean isPlaying = false;
    ImageButton playButton;
    ProgressBar progressBar;
   /* public MediaPlayer mp;*/
    public Toolbar actionBar;
    public  static MediaPlayer mediaPlayer;
    boolean mCancel=false;

  /*  public abstract String getTagText();
    public abstract boolean onBackPressed();*/
    
    @Override
    public int getTitleResourceId() {
        return TITLE_NONE;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        final Intent intent = BaseActivity.fragmentArgumentsToIntent(getArguments());
        colorResId = intent.getIntExtra(DemoSingleTopicActivity.EXTRA_FRAGMENT_COLOR, -1);
        */
    //    playButton = (ImageButton) getActivity().findViewById(R.id.bar_button_source);
       /* playButton.setBackgroundResource(android.R.drawable.ic_media_play);*/
     //   progressBar =(ProgressBar) getActivity().findViewById(R.id.progressBarr);
       /* mp=new MediaPlayer();*/
   
    }

   /* @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupBarHeader(view);
        setupBarButton(view);

        //((BaseActivity) getActivity()).getLPreviewUtils().setViewName(mHeaderBox, NativeDashFragment.VIEW_COLOR);
    }*/

  /*  protected void setupBarHeader(View rootView){
        mHeaderBox = getActivity().findViewById(R.id.header_recap);
        mHeaderContentBox = getActivity().findViewById(R.id.header_contents);
        mHeaderBackgroundBox = getActivity().findViewById(R.id.header_background);
        mHeaderShadow = getActivity().findViewById(R.id.header_shadow);

        mTitleHeader = (TextView) getActivity().findViewById(R.id.header_title);
        mSubTitleHeader = (TextView) getActivity().findViewById(R.id.header_subtitle);
    }*/

/*
    protected void setupBarButton(View rootView) {
        mSourceButton = (ImageButton) getActivity().findViewById(R.id.bar_button_source);
        //mDocButton = (ImageButton) rootView.findViewById(R.id.bar_button_doc);
        mSourceButton.setImageResource(R.drawable.ic_launcher);
*/

        /*final String sourceUrl = getSourceUrl();
        final String docUrl = getDocUrl();
*/
       /* if (mSourceButton != null) {

            ((BaseActivity) getActivity()).getLPreviewUtils().setupCircleButton(mSourceButton);

            if (sourceUrl == null) {
                mSourceButton.setEnabled(false);
            } else {

                mSourceButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(sourceUrl));
                        startActivity(i);
                    }
                });
            }
        }

        if (mDocButton != null) {
            if (docUrl == null) {
                mDocButton.setEnabled(false);
            } else {

                mDocButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(docUrl));
                        startActivity(i);
                    }
                });
            }
        }*/
  /*  }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LPreviewUtilsBase lpu = LPreviewUtils.getInstance(((BaseActivity)getActivity()));
        getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.native_background));

        float mMaxHeaderElevation = getResources().getDimensionPixelSize(
                R.dimen.carddemo_barheader_elevation);

        if (mHeaderShadow != null)
            mHeaderShadow.setVisibility(lpu.hasL() ? View.GONE : View.VISIBLE);
        if (mHeaderBackgroundBox != null)
            lpu.setViewElevation(mHeaderBackgroundBox,  mMaxHeaderElevation);
        if (mHeaderContentBox != null)
          lpu.setViewElevation(mHeaderContentBox,  mMaxHeaderElevation + 0.1f);
*/
       /* if (mTitleHeader != null)
            mTitleHeader.setText(getString(getTitleHeaderResourceId()));

        if (mSubTitleHeader != null)
            mSubTitleHeader.setText(getString(getSubTitleHeaderResourceId()));
*/

      /*  if (colorResId != -1) {
            // make sure it's opaque
            //((mSessionColor = UIUtils.setColorAlpha(mSessionColor, 255);

            mHeaderBackgroundBox.setBackgroundColor(getResources().getColor(colorResId));
            ((BaseActivity) getActivity()).getLPreviewUtils().setStatusBarColor(
                    scaleColor(getResources().getColor(colorResId), 0.8f, false));
        }
    }

    public static int scaleColor(int color, float factor, boolean scaleAlpha) {
        return Color.argb(scaleAlpha ? (Math.round(Color.alpha(color) * factor)) : Color.alpha(color),
                Math.round(Color.red(color) * factor), Math.round(Color.green(color) * factor),
                Math.round(Color.blue(color) * factor));
    }*/


  /*  protected abstract int getSubTitleHeaderResourceId();

    protected abstract int getTitleHeaderResourceId();

    protected abstract String getDocUrl();

    protected abstract String getSourceUrl();*/


    public void play(Context context, String play_url) {
        Uri myUri = Uri.parse(play_url);
        Log.d("insise play", "play" + play_url);
        if(play_url.contentEquals("stop"))
        {

        }

        try {
            if (mediaPlayer == null) {
                mediaPlayer = getMediaPlayer();
                Toast.makeText(getActivity(), "inside play", Toast.LENGTH_LONG).show();;

            } else {
                mediaPlayer.stop();
                mediaPlayer.reset();


            }
            if(play_url.contentEquals("stop"))
            {
                mediaPlayer.stop();
                mediaPlayer.reset();
                isPlaying= false;
                return;
            }
            Toast.makeText(getActivity(), "inside play 1", Toast.LENGTH_LONG).show();;

            playButton.setVisibility(View.GONE);
            //playButton.setBackgroundResource(R.color.md_black_1000);
            progressBar.setVisibility(View.VISIBLE);
            mediaPlayer.setDataSource(context, myUri); // Go to Initialized state
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepareAsync();
            isPlaying=false;
           /* progressDialog = ProgressDialog.show(context,
                    "Loading Tone", "wait....");*/
            ///   playButton.setBackgroundResource(R.drawable.);

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                   /* progressBar.setVisibility(View.VISIBLE);*/
                    //    playButton.setBackgroundResource(android.R.drawable.ic_media_pause);

                   /* if (progressDialog != null && progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }*/
                    if(mCancel){
                        mediaPlayer.release();
                        //nullify your MediaPlayer reference
                        progressBar.setVisibility(View.GONE);
                        playButton.setVisibility(View.VISIBLE);
                        playButton.setImageResource(android.R.drawable.ic_media_play);
                        mediaPlayer = null;
                        mCancel=false;
                    }
                    else {
                        mp.start();
                        progressBar.setVisibility(View.GONE);
                        playButton.setVisibility(View.VISIBLE);
                        playButton.setImageResource(android.R.drawable.ic_media_pause);
                        isPlaying=true;
                    }
                            

                }
            });
            
            mediaPlayer.start();

            // isPlaying=true;
            //   mp.setOnPreparedListener(context);
          /*  mp.setOnBufferingUpdateListener(context);

            mp.setOnErrorListener(context);*/
            //   mp.prepareAsync();

            Log.d("rbt", "LoadClip Done");
        } catch (Throwable t) {
            Log.d("rbt", t.toString());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
      
        if(mediaPlayer!=null && isPlaying)
        {
            
            
                mediaPlayer.stop();
                mediaPlayer=null;

           
           
        }
         else
         {
             cancel();
             
             
         }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mediaPlayer!=null && isPlaying)
        {


            mediaPlayer.stop();
            mediaPlayer=null;



        }
        else
        {
            cancel();


        }
       
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mediaPlayer!=null && isPlaying)
        {


            mediaPlayer.stop();
            mediaPlayer=null;



        }
        else
        {
            cancel();


        }
    }

    public static MediaPlayer getMediaPlayer() {
      
        if(mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        return mediaPlayer;
    }

    public void cancel(){
        mCancel = true;
    }
    

}
