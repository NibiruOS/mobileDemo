package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoView;

import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.api.ui.place.Place;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.bind.Bind;
import org.nibiru.ui.core.api.style.Color;

import javax.inject.Inject;

public class BindingDemoPresenter extends DemoPresenter<BindingDemoPresenter.Display> {
    public interface Display extends DemoView {
        Value<String> getLowerCase();

        Value<String> getUpperCase();

        Value<Integer> getNumber();

        Value<Integer> getIncrementedNumber();

        Value<Integer> getAmount();

        Value<Color> getAmountColor();
    }

    @Inject
    public BindingDemoPresenter(Display view, AlertManager alertManager) {
        super(view, alertManager);
    }

    @Override
    public void go(Place place) {
        Bind.on(getView().getLowerCase())
                .map(String::toUpperCase)
                .to(getView().getUpperCase());

        Bind.on(getView().getUpperCase())
                .map(String::toLowerCase)
                .to(getView().getLowerCase());

        Bind.on(getView().getNumber())
                .map((value) -> value + 1)
                .to(getView().getIncrementedNumber());

        Bind.on(getView().getIncrementedNumber())
                .map((value) -> value - 1)
                .to(getView().getNumber());

        Bind.on(getView().getAmount())
                .map((value) -> value < 0 ? Color.RED : Color.GREEN)
                .to(getView().getAmountColor());
    }
}
