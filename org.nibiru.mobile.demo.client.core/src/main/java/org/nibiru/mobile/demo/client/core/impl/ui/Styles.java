package org.nibiru.mobile.demo.client.core.impl.ui;

import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;
import org.nibiru.ui.core.impl.builder.StyleBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class Styles {
    private final Provider<StyleBuilder> style;

    @Inject
    public Styles(Provider<StyleBuilder> style) {
        this.style = checkNotNull(style);
    }

    public Style container() {
        return style.get()
                .width(Size.MATCH_PARENT)
                .height(Size.MATCH_PARENT)
                .backgroundColor(Color.WHITE)
                .build();
    }

    public Style mainMenu() {
        return style.get()
                .width(Size.WRAP_CONTENT)
                .height(Size.WRAP_CONTENT)
                .build();
    }

    public Style mainTitle() {
        return style.get()
                .marginTop(50)
                .build();
    }
}
