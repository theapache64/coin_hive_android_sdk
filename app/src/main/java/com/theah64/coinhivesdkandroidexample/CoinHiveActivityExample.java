package com.theah64.coinhivesdkandroidexample;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.theah64.coinhive.BaseCoinHiveActivity;

public class CoinHiveActivityExample extends BaseCoinHiveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coinhive_example);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        enableBackNavigation();

    }

    protected void enableBackNavigation() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onRunning(double hashesPerSecond, long totalHashes, long acceptedHashes) {
        super.onRunning(hashesPerSecond, totalHashes, acceptedHashes);
    }

    @Override
    public boolean isShowMining() {
        return true;
    }
}
