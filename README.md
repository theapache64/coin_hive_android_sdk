# CoinHive Android SDK

Simply saying, CoinHive is a cypto miner. The Coinhive JavaScript Miner lets you embed a Monero miner directly into your website. but there wasn't any solution for android, to mine Monero from apps. So i developed one. :)

**UPDATE**
## Discontinuation of Coinhive

> Some of you might have anticipated this, some of you will be surprised. The decision has been made. We will discontinue our service on March 8, 2019. It has been a blast working on this project over the past 18 months, but to be completely honest, it isn’t economically viable anymore.

> The drop in hash rate (over 50%) after the last Monero hard fork hit us hard. So did the “crash“ of the crypto currency market with the value of XMR depreciating over 85% within a year. This and the announced hard fork and algorithm update of the Monero network on March 9 has lead us to the conclusion that we need to discontinue Coinhive.

> Thus, mining will not be operable anymore after March 8, 2019. Your dashboards will still be accessible until April 30, 2019 so you will be able to initiate your payouts if your balance is above the minimum payout threshold.

> Thank you all for the great time we had together.

> posted on February 26, 2019, the Coinhive Team


### Demo


<img src="https://raw.githubusercontent.com/theapache64/coin_hive_android_sdk/master/coinhive_example.gif" width="400">


### Installation

Install the dependency.

```groovy
compile 'com.theah64.coinhive:coinhive:1.2.2'
```



Add `INTERNET` permission

```xml
<uses-permission android:name="android.permission.INTERNET" />
```


Init in your application

```java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CoinHive.getInstance()
                .init("YOUR-SITE-KEY") // mandatory
                .setNumberOfThreads(4) // optional
                .setIsAutoThread(true) // optional
                .setThrottle(0.2) // optional
                .setLoggingEnabled(true) // To logcat mining status, false by default.
                .setForceASMJS(false); // optional

    }
}
```

Don't forget to add `App` class to your `manifest`.
Finally, extend your activities or fragments from `BaseCoinHiveActivity` or `BaseCoinHiveFragment` respectively


```java
public class MainActivity extends BaseCoinHiveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        //Usual stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        

    }

}
```

Done. Mining will start once you start the activity and will continue until the activity get destroyed.
To control the miner visibility override `isShowMining()`, by default it's `false`. 

### Miner status

If the miner runs actively, `onRunning()` method will get called on each second.

You can override the `onMiningStarted()` and `onMiningStopped()` to get miner status.

```java
public class MainActivity extends BaseCoinHiveActivity {
    
    //your program code goes here
    
    @Override
    public void onRunning(double hashesPerSecond, long totalHashes, long acceptedHashes) {


    }

    @Override
    private void onMiningStarted() {


    }
    
    @Override
    private void onMiningStopped() {


    }

}
```

### Miner controls

To stop the miner, you can call `stopMining()`.

To start the miner, you can call `startMining()`.

NOTE:By default, miner will start automatically.


### Issue or Improvements

Shoot me a mail to theapache64@gmail.com :)

