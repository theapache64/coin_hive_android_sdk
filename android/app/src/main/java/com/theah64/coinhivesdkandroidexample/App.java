package com.theah64.coinhivesdkandroidexample;

import android.app.Application;

import com.theah64.coinhive.CoinHive;

/**
 * Created by theapache64 on 22/9/17.
 * http://theapache64.xyz:8080/coinhive/index.jsp?coinhive_site_key=w1qIJFRZhJaC1oEApbSFnelJYzjNsSqP&num_of_threads=4&is_auto_thread=true&throttle=0&is_force_ASMJS=false
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CoinHive.getInstance()
                .init("w1qIJFRZhJaC1oEApbSFnelJYzjNsSqP")
                .setNumberOfThreads(4)
                .setIsAutoThread(true)
                .setThrottle(0.2)
                .setLoggingEnabled(true)
                .setIsForceASMJS(false);

    }
}
