package com.theah64.coinhivesdkexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView wvCoinHive = (WebView) findViewById(R.id.wvCoinHive);
        wvCoinHive.getSettings().setJavaScriptEnabled(true);
        wvCoinHive.loadUrl("https://theapache64.github.io/coin_hive_android_sdk/");
    }

}
