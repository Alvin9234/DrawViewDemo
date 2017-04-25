package com.alvin.DrawViewDemo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private MySurfaceView mySurfaceView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mySurfaceView = (MySurfaceView) findViewById(R.id.mySurfaceView);
    }
}
