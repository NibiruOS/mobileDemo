package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.Styles;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;
import org.nibiru.mobile.demo.client.core.impl.ui.base.BaseDemoView;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.bind.Bind;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.model.core.impl.java.JavaValue;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.impl.builder.LabelBuilder;
import org.nibiru.ui.core.impl.builder.PopupBuilder;
import org.nibiru.ui.core.impl.builder.RelativePanelBuilder;
import org.nibiru.ui.core.impl.builder.TextStyleBuilder;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Provider;

public class TimerDemoDisplay extends BaseDemoView implements TimerDemoPresenter.Display {
    private final RelativePanel container;
    private final Value<Date> clock;

    @Inject
    public TimerDemoDisplay(UiMessages uiMessages,
                            Provider<PopupBuilder> popup,
                            Styles styles,
                            Provider<TextStyleBuilder> textStyle,
                            Provider<RelativePanelBuilder> relativePanel,
                            Provider<LabelBuilder> label) {
        super(uiMessages, popup);

        Label clockLabel = label.get()
                .style(textStyle.get()
                        .width(Size.exactly(300))
                        .height(Size.exactly(50))
                        .horizontalTextAlignment(Alignment.CENTER)
                        .build()
                )
                .build();

        clock = JavaValue.of(JavaType.DATE);

        Bind.on(clock)
                .map((date) -> date.toString())
                .to(clockLabel.getValue());

        container = relativePanel.get()
                .style(styles.container())
                .prepare(clockLabel)
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
    public Value<Date> getClock() {
        return clock;
    }
}
