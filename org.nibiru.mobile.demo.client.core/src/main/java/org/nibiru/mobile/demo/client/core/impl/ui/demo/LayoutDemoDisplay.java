package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.Styles;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;
import org.nibiru.mobile.demo.client.core.impl.ui.base.BaseDemoView;

import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.impl.builder.ButtonBuilder;
import org.nibiru.ui.core.impl.builder.LabelBuilder;
import org.nibiru.ui.core.impl.builder.PopupBuilder;
import org.nibiru.ui.core.impl.builder.RelativePanelBuilder;
import org.nibiru.ui.core.impl.builder.StyleBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

public class LayoutDemoDisplay extends BaseDemoView implements LayoutDemoPresenter.Display {
    private final RelativePanel container;

    @Inject
    public LayoutDemoDisplay(UiMessages uiMessages,
                             Provider<PopupBuilder> popup,
                             Styles styles,
                             Provider<StyleBuilder> style,
                             Provider<RelativePanelBuilder> relativePanel,
                             Provider<LabelBuilder> label,
                             Provider<ButtonBuilder> button) {
        super(uiMessages, popup);

        Label centered = label.get()
                .value("This is a centered text")
                .style(style.get()
                        .build()
                )
                .build();

        Label above = label.get()
                .value("Above 15 px left aligned")
                .style(style.get()
                        .marginBottom(15)
                        .build())
                .build();

        Label below = label.get()
                .value("Below 35 px rigth aligned")
                .style(style.get()
                        .marginTop(35)
                        .build())
                .build();

        container = relativePanel.get()
                .style(styles.container())
                .prepare(centered)
                .centerVertically()
                .centerHorizontally()
                .add()
                .prepare(above)
                .above(centered)
                .alignLeft(centered)
                .add()
                .prepare(below)
                .below(centered)
                .alignRight(centered)
                .add()
                .prepare(button.get()
                        .value("Below all")
                        .style(style.get()
                                .marginTop(5)
                                .backgroundColor(Color.WHITE)
                                .build())
                        .build())
                .below(below)
                .matchLeftWithLeft(below)
                .matchRightWithRight(above)
                .add()
                .build();
    }

    @Override
    public Object asNative() {
        return container.asNative();
    }
}
