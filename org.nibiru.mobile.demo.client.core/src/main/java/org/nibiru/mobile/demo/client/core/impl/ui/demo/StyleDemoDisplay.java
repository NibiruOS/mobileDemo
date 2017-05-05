package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.Styles;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;
import org.nibiru.mobile.demo.client.core.impl.ui.base.BaseDemoView;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.impl.builder.LabelBuilder;
import org.nibiru.ui.core.impl.builder.PopupBuilder;
import org.nibiru.ui.core.impl.builder.RelativePanelBuilder;
import org.nibiru.ui.core.impl.builder.TextStyleBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

public class StyleDemoDisplay extends BaseDemoView implements StyleDemoPresenter.Display {
    private final RelativePanel container;

    @Inject
    public StyleDemoDisplay(UiMessages uiMessages,
                            Provider<PopupBuilder> popup,
                            Styles styles,
                            Provider<TextStyleBuilder> textStyle,
                            Provider<RelativePanelBuilder> relativePanel,
                            Provider<LabelBuilder> label) {
        super(uiMessages, popup);

        container = relativePanel.get()
                .style(styles.container())
                .prepare(label.get()
                        .value(uiMessages.thisIsASampleText())
                        .style(textStyle.get()
                                .width(Size.exactly(300))
                                .height(Size.exactly(50))
                                .horizontalTextAlignment(Alignment.CENTER)
                                .textColor(Color.GREEN)
                                .backgroundColor(Color.RED)
                                .build()
                        )
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
}
