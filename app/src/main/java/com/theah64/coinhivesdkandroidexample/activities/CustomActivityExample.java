package com.theah64.coinhivesdkandroidexample.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.theah64.coinhive.BaseCoinHiveActivity;
import com.theah64.coinhivesdkandroidexample.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomActivityExample extends BaseCoinHiveActivity {

    //Generated with ButterLayout (http://github.com/theapache64/butterLayout): Fri Feb 02 23:56:12 IST 2018
    @BindView(R.id.aviLoading)
    AVLoadingIndicatorView aviLoading;

    @BindView(R.id.aviMining)
    AVLoadingIndicatorView aviMining;

    @BindView(R.id.tvHashesPerSecond)
    TextView tvHashesPerSecond;

    @BindView(R.id.tvTotalHashes)
    TextView tvTotalHashes;

    @BindView(R.id.tvAcceptedHashes)
    TextView tvAcceptedHashes;

    @BindView(R.id.tvStatus)
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_example);
        ButterKnife.bind(this);

        aviLoading.setVisibility(View.VISIBLE);
        aviMining.setVisibility(View.GONE);

    }

    @Override
    public void onMiningStarted() {
        aviLoading.setVisibility(View.GONE);
        aviMining.setVisibility(View.VISIBLE);
        tvStatus.setText(R.string.Mining);
    }

    @Override
    public void onMiningStopped() {
        aviLoading.setVisibility(View.GONE);
        aviMining.setVisibility(View.GONE);
        tvStatus.setText(R.string.Mining_Stopped);
    }

    @Override
    public void onRunning(final double hashesPerSecond, final long totalHashes, final long acceptedHashes) {
        tvHashesPerSecond.setText(String.valueOf(hashesPerSecond));
        tvTotalHashes.setText(String.valueOf(totalHashes));
        tvAcceptedHashes.setText(String.valueOf(acceptedHashes));
    }
}
