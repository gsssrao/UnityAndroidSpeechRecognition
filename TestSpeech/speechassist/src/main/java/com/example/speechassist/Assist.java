package com.example.speechassist;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;

import com.unity3d.player.UnityPlayer;

import java.util.Locale;

public class Assist {

        private static final int REQ_CODE_SPEECH_INPUT = 100;


        public static void promptSpeechInput() {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

            try {
                UnityPlayer.currentActivity.startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
            } catch (ActivityNotFoundException a) {
//                Toast.makeText(activity.getApplicationContext(),
//                        activity.getString(R.string.speech_not_supported),
//                        Toast.LENGTH_SHORT).show();
            }
        }




}
