package com.codekul.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "@codekul";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToSharedPrefs();

        readFromPrefrences();
    }

    private void writeToSharedPrefs(){

        SharedPreferences prefs = getSharedPreferences("my_prefs",MODE_APPEND);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("key_boolean",false);
        editor.putString("key_string", "Hello");
        editor.putInt("key_int", 10);
        editor.commit();
        Log.i(TAG, "Data written to prefs ..");
    }

    private void readFromPrefrences(){

        SharedPreferences prefs = getSharedPreferences("my_prefs",MODE_APPEND);
        Log.i(TAG, "Boolean - " + prefs.getBoolean("key_boolean",false));
        Log.i(TAG, "String - " + prefs.getString("key_string", "Problem"));
        Log.i(TAG, "Int - " + prefs.getInt("key_int", -1));
    }
}

