package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoView;

import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.api.ui.place.Place;

import javax.inject.Inject;

public class LayoutDemoPresenter  extends DemoPresenter<LayoutDemoPresenter.Display> {
    public interface Display extends DemoView {
    }

    @Inject
    public LayoutDemoPresenter(Display view, AlertManager alertManager) {
        super(view, alertManager);
    }

    @Override
    public void go(Place place) {

    }
}
