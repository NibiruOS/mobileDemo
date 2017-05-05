package org.nibiru.mobile.demo.client.core.impl.ui.base;

import com.google.common.collect.Lists;

import org.nibiru.async.core.api.promise.Promise;
import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.impl.mvp.BasePresenter;
import org.nibiru.model.core.api.Registration;

import java.util.List;

public abstract class DemoPresenter<V extends DemoView> extends BasePresenter<V> {
    private final List<Registration> registrations;

    public DemoPresenter(V view, AlertManager alertManager) {
        super(view, alertManager);
        registrations = Lists.newArrayList();
    }

    protected void runAsync(Promise<?, ?> promise) {
        getView().showLoadingIndicator();
        promise.capture(this::showException)
                .last(() -> getView().hideLoadingIndicator());
    }

    @Override
    public void onDeactivate() {
        super.onDeactivate();
        for (Registration registration : registrations) {
            registration.remove();
        }
        registrations.clear();
    }

    protected void register(Registration registration) {
        registrations.add(registration);
    }
}
