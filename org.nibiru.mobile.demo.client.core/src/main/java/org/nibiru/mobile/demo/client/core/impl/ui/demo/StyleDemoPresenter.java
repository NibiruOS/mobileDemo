package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoView;

import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.api.ui.place.Place;

import javax.inject.Inject;

public class StyleDemoPresenter extends DemoPresenter<StyleDemoPresenter.Display> {
    public interface Display extends DemoView {
    }

    @Inject
    public StyleDemoPresenter(Display view, AlertManager alertManager) {
        super(view, alertManager);
    }

    @Override
    public void go(Place place) {

    }
}
