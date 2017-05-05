package org.nibiru.mobile.demo.client.core.impl.ioc;

import org.nibiru.mobile.demo.client.core.api.business.security.Session;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;

import org.nibiru.ui.core.impl.i18n.MessageProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DemoSingletonJavaModule {
    @Provides
    @Singleton
    public Session session() {
        return new Session();
    }

    @Provides
    @Singleton
    public UiMessages uiMessages() {
        return new MessageProvider<UiMessages>(UiMessages.class).get();
    }

}
