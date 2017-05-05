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
import org.nibiru.ui.core.api.TextBox;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;
import org.nibiru.ui.core.impl.builder.LabelBuilder;
import org.nibiru.ui.core.impl.builder.PopupBuilder;
import org.nibiru.ui.core.impl.builder.RelativePanelBuilder;
import org.nibiru.ui.core.impl.builder.StyleBuilder;
import org.nibiru.ui.core.impl.builder.TextBoxBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

public class BindingDemoDisplay extends BaseDemoView implements BindingDemoPresenter.Display {
    private final RelativePanel container;
    private final TextBox lowerCase;
    private final TextBox upperCase;
    private final Value<Integer> number;
    private final Value<Integer> incrementedNumber;
    private final Value<Integer> amount;
    private final Value<Color> amountColor;

    @Inject
    public BindingDemoDisplay(UiMessages uiMessages,
                              Provider<PopupBuilder> popup,
                              Styles styles,
                              Provider<StyleBuilder> style,
                              Provider<RelativePanelBuilder> relativePanel,
                              Provider<LabelBuilder> label,
                              Provider<TextBoxBuilder> textBox) {
        super(uiMessages, popup);

        Style lstyle = style.get()
                .marginTop(40)
                .build();

        Style tbstyle = style.get()
                .width(Size.exactly(100))
                .backgroundColor(Color.WHITE)
                .build();

        Label l1;
        Label l2;
        Label l3;
        TextBox numberTb;
        TextBox incrementedNumberTb;
        TextBox amountTb;
        Label amountColorLb;

        container = relativePanel.get()
                .style(styles.container())
                .prepare(l1 = label.get()
                        .value("<->")
                        .style(lstyle)
                        .build())
                    .centerHorizontally()
                    .alignTop()
                    .add()
                .prepare(l2 = label.get()
                        .value("<->")
                        .style(lstyle)
                        .build())
                    .centerHorizontally()
                    .below(l1)
                    .add()
                .prepare(l3 = label.get()
                        .value("->")
                        .style(lstyle)
                        .build())
                    .centerHorizontally()
                    .below(l2)
                    .add()
                .prepare(lowerCase = textBox.get()
                        .style(tbstyle)
                        .build())
                    .toLeftOf(l1)
                    .centerVertically(l1)
                    .add()
                .prepare(upperCase = textBox.get()
                        .style(tbstyle)
                        .build())
                    .toRightOf(l1)
                    .centerVertically(l1)
                    .add()
                .prepare(numberTb = textBox.get()
                        .style(tbstyle)
                        .build())
                    .toLeftOf(l2)
                    .centerVertically(l2)
                    .add()
                .prepare(incrementedNumberTb = textBox.get()
                        .style(tbstyle)
                        .build())
                    .toRightOf(l2)
                    .centerVertically(l2)
                    .add()
                .prepare(amountTb = textBox.get()
                        .style(tbstyle)
                        .build())
                    .toLeftOf(l3)
                    .centerVertically(l3)
                    .add()
                .prepare(amountColorLb = label.get()
                        .value("Amount color!")
                        .style(style.get()
                                .parent(tbstyle)
                                .build())
                        .build())
                    .toRightOf(l3)
                    .centerVertically(l3)
                    .add()
                .build();

        number = JavaValue.of(JavaType.INTEGER);
        bindStringToInteger(numberTb.getValue(), number);

        incrementedNumber = JavaValue.of(JavaType.INTEGER);
        bindStringToInteger(incrementedNumberTb.getValue(), incrementedNumber);

        amount = JavaValue.of(JavaType.INTEGER);
        bindStringToInteger(amountTb.getValue(), amount);

        amountColor = JavaValue.of(JavaType.of(Color.class));
        amountColor.addObserver(() -> {
            amountColorLb.getStyle().setBackgroundColor(amountColor.get());
            amountColorLb.applyStyle();
        });
    }

    @Override
    public Object asNative() {
        return container.asNative();
    }

    @Override
    public Value<String> getLowerCase() {
        return lowerCase.getValue();
    }

    @Override
    public Value<String> getUpperCase() {
        return upperCase.getValue();
    }

    @Override
    public Value<Integer> getNumber() {
        return number;
    }

    @Override
    public Value<Integer> getIncrementedNumber() {
        return incrementedNumber;
    }

    @Override
    public Value<Integer> getAmount() {
        return amount;
    }

    @Override
    public Value<Color> getAmountColor() {
        return amountColor;
    }

    private void bindStringToInteger(Value<String> string, Value<Integer> integer) {
        Bind.on(string)
                .map((value) -> {
                    try {
                        return Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                })
                .to(integer);

        Bind.on(integer)
                .map((value) -> value != null ? value.toString() : "")
                .to(string);
    }
}
