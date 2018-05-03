package com.plugin.speech.pluginlibrary;

import android.content.Intent;
import android.speech.RecognizerIntent;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import android.util.Log;

import java.util.Locale;

public class ActivityClass extends UnityPlayerActivity {
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    public static String objectname = "Main Camera";
    public static int maxResults = 10;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    //String match = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0);
                    String matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0);
                    for (int i = 1; i< data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).size(); i++){
                        matches = matches + "~"+ data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(i);
                    }
                    Log.i("UnityTag", String.valueOf(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).size()));
                    UnityPlayer.UnitySendMessage(objectname, "onActivityResult", matches);
                    Log.i("UnityTag", matches);
                }
                break;
            }

        }
    }
}
