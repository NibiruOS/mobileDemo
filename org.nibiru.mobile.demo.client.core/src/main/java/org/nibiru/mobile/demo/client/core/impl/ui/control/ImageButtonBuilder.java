package org.nibiru.mobile.demo.client.core.impl.ui.control;

import org.nibiru.ui.core.impl.builder.BaseClickableValueBuilder;

import javax.inject.Inject;

public class ImageButtonBuilder  extends BaseClickableValueBuilder<ImageButton, String, ImageButtonBuilder> {
    @Inject
    public ImageButtonBuilder(ImageButton control) {
        super(control);
    }

    public ImageButtonBuilder image(String image) {
        object.getImage().set(image);
        return this;
    }
}
