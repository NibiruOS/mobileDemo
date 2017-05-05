package org.nibiru.mobile.demo.client.android.app;

import android.app.Activity;

public final class ComponentHelper {
    private ComponentHelper() {
    }

    public static UserComponent component(Activity activity) {
        DemoApplication app = (DemoApplication) activity.getApplication();
        return DaggerUserComponent.builder()
                .activityComponent(DaggerActivityComponent.builder()
                        .activityModule(new ActivityModule(activity))
                        .appComponent(app.getAppComponent())
                        .build())
                .build();
    }
}
