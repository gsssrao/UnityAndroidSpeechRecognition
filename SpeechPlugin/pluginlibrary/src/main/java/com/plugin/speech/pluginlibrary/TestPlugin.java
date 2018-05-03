package com.plugin.speech.pluginlibrary;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;

import com.unity3d.player.UnityPlayer;

import java.util.Locale;

public class TestPlugin {
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private static String gQuestion = "Hello, How can I help you?";
    private static boolean languageNotSet = true;
    private static String glanguage = "en-US";
    private static int gMaxResults= 10;


    public static String getMessage() {
        return "Hello World!";
    }

    public static void setReturnObject(String objectname) {
        ActivityClass.objectname = objectname;
    }

    public static void changeQuestion(String question) {
        gQuestion = question;
    }

    public static void setLanguage(String language) {
        languageNotSet = false;
        glanguage = language;
    }

    public static void setMaxResults(int maxResults) {
        gMaxResults = maxResults;
        ActivityClass.maxResults = maxResults;
    }

    public static void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        if(languageNotSet)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        else
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, glanguage);
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, gMaxResults);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, gQuestion);

        try {
            UnityPlayer.currentActivity.startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
        }
    }
}
