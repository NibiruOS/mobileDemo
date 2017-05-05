package org.nibiru.mobile.demo.client.android.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class DemoApplication extends Application {
    private final AppComponent appComponent = DaggerAppComponent.create();

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
