package org.nibiru.mobile.demo.client.core.impl.ui.demo;

import org.nibiru.mobile.demo.client.core.impl.ui.Styles;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;
import org.nibiru.mobile.demo.client.core.impl.ui.base.BaseDemoView;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.TextBox;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.impl.builder.LabelBuilder;
import org.nibiru.ui.core.impl.builder.PopupBuilder;
import org.nibiru.ui.core.impl.builder.RelativePanelBuilder;
import org.nibiru.ui.core.impl.builder.StyleBuilder;
import org.nibiru.ui.core.impl.builder.TextBoxBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

public class PushDemoDisplay extends BaseDemoView implements PushDemoPresenter.Display {
    private final RelativePanel container;
    private final TextBox firstName;
    private final TextBox lastName;
    private final Label message;

    @Inject
    public PushDemoDisplay(UiMessages uiMessages,
                           Provider<PopupBuilder> popup,
                           Styles styles,
                           Provider<StyleBuilder> style,
                           Provider<RelativePanelBuilder> relativePanel,
                           Provider<LabelBuilder> label,
                           Provider<TextBoxBuilder> textBox) {
        super(uiMessages, popup);


        firstName = textBox.get()
                .style(style.get()
                        .marginTop(30)
                        .width(Size.exactly(100))
                        .backgroundColor(Color.WHITE)
                        .build())
                .build();
        lastName = textBox.get()
                .style(style.get()
                        .marginTop(10)
                        .width(Size.exactly(100))
                        .backgroundColor(Color.WHITE)
                        .build())
                .build();


        container = relativePanel.get()
                .style(styles.container())
                .prepare(firstName)
                    .centerHorizontally()
                    .alignTop()
                    .add()
                .prepare(lastName)
                    .below(firstName)
                    .alignLeft(firstName)
                    .add()
                .prepare(label.get()
                        .value("First Name:")
                        .build())
                    .centerVertically(firstName)
                    .toLeftOf(firstName)
                    .add()
                .prepare(label.get()
                        .value("Last Name:")
                        .build())
                    .centerVertically(lastName)
                    .toLeftOf(lastName)
                    .add()
                .prepare(message = label.get()
                        .style(style.get()
                                .marginTop(10)
                                .width(Size.exactly(200))
                                .height(Size.exactly(30))
                                .backgroundColor(new Color(224, 224, 224))
                                .build())
                        .build())
                    .centerHorizontally()
                    .below(lastName)
                    .add()
                .build();
    }

    @Override
    public Object asNative() {
        return container.asNative();
    }

    @Override
    public Value<String> getFirstName() {
        return firstName.getValue();
    }

    @Override
    public Value<String> getLastName() {
        return lastName.getValue();
    }

    @Override
    public Value<String> getMessage() {
        return message.getValue();
    }
}
