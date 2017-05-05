package org.nibiru.mobile.demo.client.core.impl.ui.shipment;

import org.nibiru.mobile.demo.client.core.api.business.security.Session;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoPresenter;
import org.nibiru.mobile.demo.client.core.impl.ui.base.DemoView;

import org.nibiru.mobile.core.api.ui.AlertManager;
import org.nibiru.mobile.core.api.ui.place.Place;
import org.nibiru.mobile.core.api.ui.place.PlaceManager;
import org.nibiru.model.core.api.Value;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class ReceiveShipmentPresenter extends DemoPresenter<ReceiveShipmentPresenter.Display> {
    public interface Display extends DemoView {
        Value<String> getUserName();
    }

    private final PlaceManager placeManager;
    private final Session session;

    @Inject
    public ReceiveShipmentPresenter(ReceiveShipmentPresenter.Display view,
                                    AlertManager alertManager,
                                    PlaceManager placeManager,
                                    Session session) {
        super(view, alertManager);
        this.placeManager = checkNotNull(placeManager);
        this.session = checkNotNull(session);
    }

    @Override
    public void go(Place place) {
        getView().getUserName().set(session.getUser().getFirstName()
                + " "
                + session.getUser().getLastName());
    }
}
