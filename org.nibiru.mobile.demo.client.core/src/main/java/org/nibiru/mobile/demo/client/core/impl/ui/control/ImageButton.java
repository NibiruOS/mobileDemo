package org.nibiru.mobile.demo.client.core.impl.ui.control;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.IsParent;
import org.nibiru.ui.core.api.ValueWidget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Style;
import org.nibiru.ui.core.impl.builder.ButtonBuilder;
import org.nibiru.ui.core.impl.builder.HorizontalPanelBuilder;
import org.nibiru.ui.core.impl.builder.ImageBuilder;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

public class ImageButton implements ValueWidget<String>, HasClickHandler {
    private final HorizontalPanel container;
    private final Image image;
    private final Button button;

    @Inject
    public ImageButton(Provider<HorizontalPanelBuilder> horizontalPanel,
                       Provider<ImageBuilder> image,
                       Provider<ButtonBuilder> button) {
        container = horizontalPanel.get()
                .add(this.image = image.get()
                        .build())
                .add(this.button = button.get()
                        .build())
                .build();
    }

    @Override
    public Value<String> getValue() {
        return button.getValue();
    }

    public Value<String> getImage() {
        return image.getValue();
    }

    @Override
    public Object asNative() {
        return container.asNative();
    }

    @Override
    public void setStyleName(Enum<?> style) {
        container.setStyleName(style);
    }

    @Override
    public void measure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        container.measure(widthSpec, heightSpec);
    }

    @Override
    public int getMeasuredHeight() {
        return container.getMeasuredHeight();
    }

    @Override
    public int getMeasuredWidth() {
        return container.getMeasuredWidth();
    }

    @Override
    public void layout() {
        container.layout();
    }

    @Nullable
    @Override
    public IsParent getParent() {
        return container.getParent();
    }

    @Override
    public void setParent(@Nullable IsParent parent) {
        container.setParent(parent);
    }

    @Override
    public void setStyle(Style style) {
        container.setStyle(style);
    }

    @Override
    public Style getStyle() {
        return container.getStyle();
    }

    @Override
    public void applyStyle() {
        container.applyStyle();
    }

    @Override
    public Registration setClickHandler(ClickHandler clickHandler) {
        Registration imageRegistration = image.setClickHandler(clickHandler);
        Registration buttonRegistration = button.setClickHandler(clickHandler);
        return () -> {
            imageRegistration.remove();
            buttonRegistration.remove();
        };
    }
}
