package org.nibiru.mobile.demo.client.gwt.app;

import com.google.gwt.core.client.GWT;
import org.nibiru.mobile.demo.client.core.api.business.security.Session;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;
import org.nibiru.mobile.demo.client.gwt.service.AutoBeanDtoFactory;
import org.nibiru.mobile.demo.client.gwt.ui.GwtUiMessages;
import org.nibiru.mobile.demo.shared.api.service.StatusDto;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import org.nibiru.mobile.core.api.config.BaseUrl;
import org.nibiru.mobile.core.api.serializer.Serializer;
import org.nibiru.mobile.gwt.app.DatabaseBootstrap;
import org.nibiru.mobile.gwt.data.DummyDatabaseBootstrap;
import org.nibiru.mobile.gwt.serializer.AutoBeanSerializer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DemoGwtModule {
    @Provides
    @Singleton
    public Session session() {
        return new Session();
    }

    /* UI bindings */
    @Provides
    public UiMessages getUiMessages() {
        return GWT.create(GwtUiMessages.class);
    }

    /* Database bindings */
    @Provides
    public DatabaseBootstrap getDatabaseBootstrap(DummyDatabaseBootstrap dbBootstrap) {
        return dbBootstrap;
    }

    @Provides
    @BaseUrl
    public String baseUrl() {
        return GWT.getHostPageBaseURL() + "../org.nibiru.mobile.demo.server/";
    }

    @Provides
    public Serializer serializer(AutoBeanDtoFactory dtoFactory) {
        return new AutoBeanSerializer(dtoFactory);
    }

    @Provides
    public AutoBeanDtoFactory autoBeanDtoFactory() {
        return GWT.create(AutoBeanDtoFactory.class);
    }

    @Provides
    public StatusDto statusDto(AutoBeanDtoFactory dtoFactory) {
        return dtoFactory.status().as();
    }

    @Provides
    public UserDto user(AutoBeanDtoFactory dtoFactory) {
        return dtoFactory.user().as();
    }
}
