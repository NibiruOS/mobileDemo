package org.nibiru.mobile.demo.client.ios.app;

import org.nibiru.mobile.demo.client.core.impl.ioc.DemoJavaModule;
import org.nibiru.mobile.demo.client.core.impl.ioc.DemoModule;
import org.nibiru.mobile.demo.client.core.impl.ioc.DemoSingletonJavaModule;

import org.nibiru.mobile.core.api.app.Bootstrap;
import org.nibiru.mobile.ios.ioc.DefaultCoreDataModule;
import org.nibiru.mobile.ios.ioc.DefaultIosHardwareModule;
import org.nibiru.mobile.ios.ioc.DefaultIosModule;
import org.nibiru.mobile.java.ioc.DefaultJavaModule;
import org.nibiru.ui.core.impl.ioc.CoreModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {DemoModule.class,
        DemoJavaModule.class,
        DemoSingletonJavaModule.class,
        DefaultJavaModule.class,
        DefaultIosModule.class,
        DefaultIosHardwareModule.class,
        DefaultCoreDataModule.class,
        CoreModule.class,
        org.nibiru.ui.ios.ioc.IOSModule.class,
        org.nibiru.async.ios.ioc.IOSModule.class})
@Singleton
public interface Injector {
    Bootstrap getBootstrap();
}
