package org.nibiru.mobile.demo.client.android.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity activity() {
        return activity;
    }

    @Provides
    @ActivityScope
    public Context context(Activity activity) {
        return activity;
    }

    @Provides
    @ActivityScope
    public Resources resources(Context context) {
        return context.getResources();
    }
}
