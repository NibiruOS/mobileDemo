package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoView;

import org.nibiru.async.core.api.timer.Timer;
import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.api.ui.place.Place;
import org.nibiru.model.core.api.Value;

import java.util.Date;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class TimerDemoPresenter extends DemoPresenter<TimerDemoPresenter.Display> {
    public interface Display extends DemoView {
        Value<Date> getClock();
    }

    private final Timer timer;
    @Inject
    public TimerDemoPresenter(Display view,
                              AlertManager alertManager,
                              Timer timer) {
        super(view, alertManager);
        this.timer = checkNotNull(timer);
    }

    @Override
    public void go(Place place) {
    }

    @Override
    public void onActivate() {
        super.onActivate();
        timer.scheduleRepeating(() -> getView().getClock().set(new Date()), 1000);
    }
}
