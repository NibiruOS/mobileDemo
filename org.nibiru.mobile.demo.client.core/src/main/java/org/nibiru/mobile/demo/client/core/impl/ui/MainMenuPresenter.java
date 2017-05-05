package org.nibiru.mobile.demo.client.core.impl.ui;

import org.nibiru.mobile.demo.client.core.api.business.security.SecurityManager;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoView;

import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.api.ui.place.Place;
import org.nibiru.mobile.core.api.ui.place.PlaceManager;
import org.nibiru.ui.core.api.HasClickHandler;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainMenuPresenter extends DemoPresenter<MainMenuPresenter.Display> {
    public interface Display extends DemoView {
        HasClickHandler getServerLogin();
        HasClickHandler getStyleDemo();
        HasClickHandler getLayoutDemo();
        HasClickHandler getPushDemo();
        HasClickHandler getTimerDemo();
        HasClickHandler getBindingDemo();
    }

    private final PlaceManager placeManager;
    private final SecurityManager securityManager;
    private final UiMessages uiMessages;

    @Inject
    public MainMenuPresenter(Display view,
                             AlertManager alertManager,
                             PlaceManager placeManager,
                             SecurityManager securityManager,
                             UiMessages uiMessages) {
        super(view, alertManager);
        this.placeManager = checkNotNull(placeManager);
        this.securityManager = checkNotNull(securityManager);
        this.uiMessages = checkNotNull(uiMessages);
    }

    @Override
    public void go(Place place) {
        getView().getServerLogin().setClickHandler(() -> {
            getAlertManager().prompt(uiMessages.authentication(),
                    uiMessages.enterScanUserCredentials(),
                    (value) -> {
                        if (value != null) {
                            runAsync(securityManager.login(value)
                                    .then((result) -> placeManager.createPlace(Places.RECEIVE_SHIPMENT)
                                            .go(true, true)));
                        }
                    });
        });
        getView().getStyleDemo().setClickHandler(() -> {
            placeManager.createPlace(Places.STYLE_DEMO)
                    .go(true, true);
        });
        getView().getLayoutDemo().setClickHandler(() -> {
            placeManager.createPlace(Places.LAYOUT_DEMO)
                    .go(true, true);
        });
        getView().getPushDemo().setClickHandler(() -> {
            placeManager.createPlace(Places.PUSH_DEMO)
                    .go(true, true);
        });
        getView().getTimerDemo().setClickHandler(() -> {
            placeManager.createPlace(Places.TIMER_DEMO)
                    .go(true, true);
        });
        getView().getBindingDemo().setClickHandler(() -> {
            placeManager.createPlace(Places.BINDING_DEMO)
                    .go(true, true);
        });
    }
}
