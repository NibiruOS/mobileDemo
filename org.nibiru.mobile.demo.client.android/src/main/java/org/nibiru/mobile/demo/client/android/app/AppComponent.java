package org.nibiru.mobile.demo.client.android.app;

import org.nibiru.mobile.demo.client.core.api.business.security.Session;
import org.nibiru.mobile.demo.client.core.impl.ioc.DemoSingletonJavaModule;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DemoSingletonJavaModule.class)
public interface AppComponent {
    Session session();

    UiMessages uiMessages();
}
