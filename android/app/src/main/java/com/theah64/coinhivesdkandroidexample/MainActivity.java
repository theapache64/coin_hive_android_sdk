package com.theah64.coinhivesdkandroidexample;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.theah64.coinhive.BaseCoinHiveActivity;

public class MainActivity extends BaseCoinHiveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public void onRunning(double hashesPerSecond, long totalHashes, long acceptedHashes) {
        super.onRunning(hashesPerSecond, totalHashes, acceptedHashes);
    }

    @Override
    public boolean isHideMining() {
        return false;
    }

}
