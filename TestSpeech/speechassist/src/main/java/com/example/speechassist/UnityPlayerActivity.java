package com.example.speechassist;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;

import com.unity3d.player.UnityPlayer;

public class UnityPlayerActivity extends com.unity3d.player.UnityPlayerActivity
{
    //private UnityPlayer mUnityPlayer;
    private static final int REQ_CODE_SPEECH_INPUT = 100;

    // UnityPlayer.init() should be called before attaching the view to a layout - it will load the native code.
    // UnityPlayer.quit() should be the last thing called - it will unload the native code.
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		/*
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mUnityPlayer = new UnityPlayer(this);
		if (mUnityPlayer.getSettings ().getBoolean ("hide_status_bar", true))
			getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,
			                       WindowManager.LayoutParams.FLAG_FULLSCREEN);
		int glesMode = mUnityPlayer.getSettings().getInt("gles_mode", 1);
		boolean trueColor8888 = false;
		mUnityPlayer.init(glesMode, trueColor8888);
		View playerView = mUnityPlayer.getView();
		setContentView(playerView);
		playerView.requestFocus();
		*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    UnityPlayer.UnitySendMessage("MainCamera", "onActivityResult", data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
                    String match = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0);
                    Log.i("UnityTag", match);
                    super.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }


	/*

	protected void onDestroy ()
	{
		mUnityPlayer.quit();
		super.onDestroy();
	}
	// onPause()/onResume() must be sent to UnityPlayer to enable pause and resource recreation on resume.
	protected void onPause()
	{
		super.onPause();
		mUnityPlayer.pause();
	}
	protected void onResume()
	{
		super.onResume();
		mUnityPlayer.resume();
	}
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		mUnityPlayer.configurationChanged(newConfig);
	}
	public void onWindowFocusChanged(boolean hasFocus)
	{
		super.onWindowFocusChanged(hasFocus);
		mUnityPlayer.windowFocusChanged(hasFocus);
	}
	// Pass any keys not handled by (unfocused) views straight to UnityPlayer
	public boolean onKeyMultiple(int keyCode, int count, KeyEvent event)
	{
		return mUnityPlayer.onKeyMultiple(keyCode, count, event);
	}
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		return mUnityPlayer.onKeyDown(keyCode, event);
	}
	public boolean onKeyUp(int keyCode, KeyEvent event)
	{
		return mUnityPlayer.onKeyUp(keyCode, event);
	}
	*/
}