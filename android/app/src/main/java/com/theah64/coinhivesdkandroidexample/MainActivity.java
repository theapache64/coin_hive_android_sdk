package com.theah64.coinhivesdkandroidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.theah64.coinhive.BaseCoinHiveActivity;

public class MainActivity extends BaseCoinHiveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
