package org.nibiru.mobile.demo.client.core.impl.ui;

import org.nibiru.mobile.demo.client.core.impl.ui.demo.BindingDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.LayoutDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.PushDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.StyleDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.demo.TimerDemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.shipment.ReceiveShipmentPresenter;

import org.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import org.nibiru.mobile.core.impl.mvp.BasePresenterMapper;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class AppPresenterMapper extends BasePresenterMapper {
    @Inject
    public AppPresenterMapper(Provider<MainMenuPresenter> mainMenu,
                              Provider<ReceiveShipmentPresenter> receiveShipment,
                              Provider<StyleDemoPresenter> styleDemo,
                              Provider<LayoutDemoPresenter> layoutDemo,
                              Provider<PushDemoPresenter> pushDemo,
                              Provider<TimerDemoPresenter> timerDemo,
                              Provider<BindingDemoPresenter> bindingDemo) {
        checkNotNull(mainMenu);
        map(DefaultPlaces.HOME, mainMenu);
        map(Places.RECEIVE_SHIPMENT, receiveShipment);
        map(Places.STYLE_DEMO, styleDemo);
        map(Places.LAYOUT_DEMO, layoutDemo);
        map(Places.PUSH_DEMO, pushDemo);
        map(Places.TIMER_DEMO, timerDemo);
        map(Places.BINDING_DEMO, bindingDemo);
    }
}
