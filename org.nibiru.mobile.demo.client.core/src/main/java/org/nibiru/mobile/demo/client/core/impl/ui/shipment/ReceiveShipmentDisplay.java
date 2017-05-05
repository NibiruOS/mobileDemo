package org.nibiru.mobile.demo.client.core.impl.ui.shipment;

import org.nibiru.mobile.demo.client.core.impl.ui.Styles;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;
import org.nibiru.mobile.demo.client.core.impl.ui.base.BaseDemoView;
import org.nibiru.mobile.demo.client.core.impl.ui.control.ImageButtonBuilder;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.impl.builder.LabelBuilder;
import org.nibiru.ui.core.impl.builder.PopupBuilder;
import org.nibiru.ui.core.impl.builder.RelativePanelBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

public class ReceiveShipmentDisplay extends BaseDemoView implements ReceiveShipmentPresenter.Display {
    private final RelativePanel container;
    private final Label userName;


    @Inject
    public ReceiveShipmentDisplay(UiMessages uiMessages,
                                  Styles styles,
                                  Provider<PopupBuilder> popup,
                                  Provider<RelativePanelBuilder> relativePanel,
                                  Provider<LabelBuilder> label,
                                  Provider<ImageButtonBuilder> button) {
        super(uiMessages, popup);

        userName = label.get()
                .build();

        container = relativePanel.get()
                .style(styles.container())
                .prepare(userName)
                    .alignTop()
                    .centerHorizontally()
                    .add()
                .prepare(label.get()
                        .value(uiMessages.serverLogin())
                        .build())
                    .below(userName)
                    .centerHorizontally()
                    .add()
                .prepare(button.get()
                        .value(uiMessages.addNewPallet())
                        .image("add_big.png")
                        .build())
                    .centerVertically()
                    .centerHorizontally()
                    .add()
                .build();
    }

    @Override
    public Object asNative() {
        return container.asNative();
    }

    @Override
    public Value<String> getUserName() {
        return userName.getValue();
    }
}