package org.nibiru.mobile.demo.client.core.impl.ioc;

import org.nibiru.mobile.demo.client.core.api.business.security.SecurityManager;
import org.nibiru.mobile.demo.client.core.api.service.security.SecurityService;
import org.nibiru.mobile.demo.client.core.impl.AppEntryPoint;
import org.nibiru.mobile.demo.client.core.impl.business.security.SecurityManagerImpl;
import org.nibiru.mobile.demo.client.core.impl.service.security.SecurityServiceImpl;
import org.nibiru.mobile.demo.client.core.impl.ui.AppPresenterMapper;
import org.nibiru.mobile.demo.client.core.impl.ui.MainMenuDisplay;
import org.nibiru.mobile.demo.client.core.impl.ui.MainMenuPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.BindingDemoDisplay;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.BindingDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.LayoutDemoDisplay;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.LayoutDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.PushDemoDisplay;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.PushDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.StyleDemoDisplay;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.StyleDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.TimerDemoDisplay;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.TimerDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.shipment.ReceiveShipmentDisplay;
import org.nibiru.mobile.demo.client.core.impl.ui.shipment.ReceiveShipmentPresenter;
import org.nibiru.mobile.demo.shared.api.app.AppConstants;
import org.nibiru.mobile.demo.shared.api.service.Paths;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import org.nibiru.mobile.core.api.app.EntryPoint;
import org.nibiru.mobile.core.api.config.AppName;
import org.nibiru.mobile.core.api.config.AppVersion;
import org.nibiru.mobile.core.api.config.BaseUrl;
import org.nibiru.mobile.core.api.http.HttpManager;
import org.nibiru.mobile.core.api.serializer.Serializer;
import org.nibiru.mobile.core.api.service.BasicPushServiceFactory;
import org.nibiru.mobile.core.api.service.PushService;
import org.nibiru.mobile.core.api.service.RemoteService;
import org.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import org.nibiru.mobile.core.impl.service.RestService;
import org.nibiru.mobile.core.impl.service.SerializablePushService;
import org.nibiru.ui.core.api.ResourcesBasePath;

import dagger.Module;
import dagger.Provides;

@Module
public class DemoModule {
    @Provides
    public EntryPoint getEntryPoint(AppEntryPoint entryPoint) {
        return entryPoint;
    }

    /* UI bindings */
    @Provides
    public PresenterMapper getPresenterMapper(AppPresenterMapper manager) {
        return manager;
    }

    @Provides
    public MainMenuPresenter.Display getMainMenuDisplay(MainMenuDisplay display) {
        return display;
    }

    @Provides
    public ReceiveShipmentPresenter.Display getReceiveShipmentDisplay(ReceiveShipmentDisplay display) {
        return display;
    }

    @Provides
    public StyleDemoPresenter.Display getStyleDemoDisplay(StyleDemoDisplay display) {
        return display;
    }

    @Provides
    public LayoutDemoPresenter.Display getLayoutDemoDisplay(LayoutDemoDisplay display) {
        return display;
    }

    @Provides
    public PushDemoPresenter.Display getPushDemoDisplay(PushDemoDisplay display) {
        return display;
    }

    @Provides
    public TimerDemoPresenter.Display getTimerDemoDisplay(TimerDemoDisplay display) {
        return display;
    }

    @Provides
    public BindingDemoPresenter.Display getBindingDemoDisplay(BindingDemoDisplay display) {
        return display;
    }

    /* Business bindings */
    @Provides
    public SecurityManager getSecurityManager(SecurityManagerImpl manager) {
        return manager;
    }

    /* Service bindings */
    @Provides
    public RemoteService remoteService(@BaseUrl String baseUrl, HttpManager httpManager, Serializer serializer) {
        return new RestService(baseUrl, Paths.USER_SERVICE, httpManager, serializer);
    }

    @Provides
    public SecurityService getSecurityService(SecurityServiceImpl service) {
        return service;
    }

    @Provides
    public PushService<UserDto> getPush(BasicPushServiceFactory factory,
                                        Serializer serializer,
                                        @BaseUrl String baseUrl) {
        String wsUrl = baseUrl.replaceAll("http://", "ws://") + Paths.MESSAGE;
        return new SerializablePushService<>(factory.create(wsUrl),
                serializer,
                UserDto.class);
//        return new SerializablePushService<>(factory.create("ws://echo.websocket.org"),
//                serializer,
//                UserDto.class);
    }

    @Provides
    @AppName
    public String appName() {
        return AppConstants.APP_NAME;
    }

    @Provides
    @AppVersion
    public Integer appVersion() {
        return AppConstants.APP_VERSION;
    }

    @Provides
    @ResourcesBasePath
    public String resourcesBasePath() {
        return "org/nibiru/mobile/demo/client/core/resources/";
    }
}
