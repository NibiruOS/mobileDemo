package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoView;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import org.nibiru.mobile.core.api.service.PushService;
import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.api.ui.place.Place;
import org.nibiru.model.core.api.Value;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class PushDemoPresenter extends DemoPresenter<PushDemoPresenter.Display> {
    public interface Display extends DemoView {
        Value<String> getFirstName();

        Value<String> getLastName();

        Value<String> getMessage();
    }

    private final PushService<UserDto> push;
    private final Provider<UserDto> dtoFactory;

    @Inject
    public PushDemoPresenter(Display view,
                             AlertManager alertManager,
                             PushService<UserDto> push,
                             Provider<UserDto> dtoFactory) {
        super(view, alertManager);
        this.push = checkNotNull(push);
        this.dtoFactory = checkNotNull(dtoFactory);
    }

    @Override
    public void go(Place place) {
    }

    @Override
    public void onActivate() {
        super.onActivate();
        push.connect()
                .last(() -> {
                    Runnable pushAction = () -> {
                        UserDto dto = dtoFactory.get();
                        dto.setFirstName(getView().getFirstName().get());
                        dto.setLastName(getView().getLastName().get());
                        push.send(dto);
                    };
                    register(getView().getFirstName().addObserver(pushAction));
                    register(getView().getLastName().addObserver(pushAction));
                    register(push.receive((user) -> getView().getMessage().set("Hi " + user.getFirstName() + " " + user.getLastName())));

                })
                .capture(this::showException);
    }

    @Override
    public void onDeactivate() {
        super.onDeactivate();
        push.disconnect();
    }
}
