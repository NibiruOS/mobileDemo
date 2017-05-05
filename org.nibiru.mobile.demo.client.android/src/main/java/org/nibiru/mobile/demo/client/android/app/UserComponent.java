package org.nibiru.mobile.demo.client.android.app;

import org.nibiru.mobile.demo.client.core.impl.ioc.DemoJavaModule;
import org.nibiru.mobile.demo.client.core.impl.ioc.DemoModule;

import org.nibiru.mobile.android.ioc.DefaultAndroidHardwareModule;
import org.nibiru.mobile.android.ioc.DefaultAndroidModule;
import org.nibiru.mobile.android.ui.mvp.PresenterAdapter;
import org.nibiru.mobile.core.api.app.Bootstrap;
import org.nibiru.mobile.core.api.ui.place.PlaceManager;
import org.nibiru.mobile.java.ioc.DefaultJavaModule;
import org.nibiru.ui.android.ioc.AndroidModule;
import org.nibiru.ui.core.impl.ioc.CoreModule;

import dagger.Component;

@Component(modules = {DemoModule.class,
        DemoJavaModule.class,
        DemoAndroidModule.class,
        DefaultJavaModule.class,
        DefaultAndroidModule.class,
        DefaultAndroidHardwareModule.class,
        CoreModule.class,
        AndroidModule.class,
        org.nibiru.async.android.ioc.AndroidModule.class},
        dependencies = ActivityComponent.class)
@UserScope
public interface UserComponent extends ActivityComponent {
    Bootstrap getBootstrap();

    PresenterAdapter getPresenterAdapter();

    PlaceManager getPlaceManager();
}
