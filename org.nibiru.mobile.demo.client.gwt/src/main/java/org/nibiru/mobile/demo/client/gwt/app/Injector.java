package org.nibiru.mobile.demo.client.gwt.app;

import org.nibiru.mobile.demo.client.core.impl.ioc.DemoModule;

import org.nibiru.mobile.core.api.app.Bootstrap;
import org.nibiru.mobile.gwt.ioc.DefaultGwtHardwareModule;
import org.nibiru.mobile.gwt.ioc.DefaultGwtModule;
import org.nibiru.mobile.gwt.ioc.DefaultGwtPlacesModule;
import org.nibiru.mobile.gwt.ioc.DefaultGwtUiModule;
import org.nibiru.ui.core.impl.ioc.CoreModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {DemoModule.class,
        DemoGwtModule.class,
        DefaultGwtModule.class,
        DefaultGwtHardwareModule.class,
        DefaultGwtPlacesModule.class,
        DefaultGwtUiModule.class,
        CoreModule.class,
        org.nibiru.ui.gwt.ioc.GwtModule.class,
        org.nibiru.async.gwt.ioc.GwtModule.class})
@Singleton
public interface Injector {
    Bootstrap getBootstrap();
}
