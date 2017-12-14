package com.theah64.coinhive;

import android.support.v4.app.Fragment;

/**
 * Created by theapache64 on 13/12/17.
 */

public abstract class BaseCoinHiveFragment extends Fragment implements CoinHive.Callback {

    private CoinHive.Miner wvCoinHive;

    @Override
    public void onStart() {
        super.onStart();

        wvCoinHive = new CoinHive.Miner(getActivity(), this);
    }

    public void stopMining() {
        wvCoinHive.stopMining();
    }

    public void startMining() {
        wvCoinHive.startMining();
    }


    @Override
    public void onDestroy() {
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
