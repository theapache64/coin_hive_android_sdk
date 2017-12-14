package com.theah64.coinhive;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by theapache64 on 22/9/17.
 */

public class BaseCoinHiveActivity extends AppCompatActivity implements CoinHive.Callback {


    private CoinHive.Miner wvCoinHive;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        wvCoinHive = new CoinHive.Miner(this, this);
    }


    public void stopMining() {
        wvCoinHive.stopMining();
    }

    public void startMining() {
        wvCoinHive.startMining();
    }


    @Override
    protected void onDestroy() {
        if (CoinHive.getInstance().isLoggingEnabled()) {
            System.out.println("Mining stopped");
        }
        stopMining();
        super.onDestroy();
    }

    @Override
    public boolean isShowMining() {
        return false;
    }

    @Override
    public void onMiningStarted() {

    }

    @Override
    public void onMiningStopped() {

    }

    @Override
    public void onRunning(double hashesPerSecond, long totalHashes, long acceptedHashes) {

    }
}
