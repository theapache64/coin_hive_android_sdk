# CoinHive Android SDK

Simply saying, CoinHive is a cypto miner. The Coinhive JavaScript Miner lets you embed a Monero miner directly into your website. but there wasn't any solution for android, to mine Monero from apps. So i developed one. :)

### Installation

Install the dependency.

```groovy
compile 'com.theah64.coinhive:coinhive:1.0.2'
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

### Issue or Improvements

Shoot me a mail to theapache64@gmail.com :)

