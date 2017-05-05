package org.nibiru.mobile.demo.client.core.impl.ui;

import org.nibiru.mobile.demo.client.core.impl.ui.base.BaseDemoView;
import org.nibiru.mobile.demo.client.core.impl.ui.control.ImageButton;
import org.nibiru.mobile.demo.client.core.impl.ui.control.ImageButtonBuilder;

import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.impl.builder.GridPanelBuilder;
import org.nibiru.ui.core.impl.builder.ImageBuilder;
import org.nibiru.ui.core.impl.builder.PopupBuilder;
import org.nibiru.ui.core.impl.builder.RelativePanelBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

public class MainMenuDisplay extends BaseDemoView implements MainMenuPresenter.Display {
    private final RelativePanel container;
    private final ImageButton serverLogin;
    private final ImageButton styleDemo;
    private final ImageButton layoutDemo;
    private final ImageButton pushDemo;
    private final ImageButton timerDemo;
    private final ImageButton bindingDemo;

    @Inject
    public MainMenuDisplay(UiMessages uiMessages,
                           Styles styles,
                           Provider<PopupBuilder> popup,
                           Provider<RelativePanelBuilder> relativePanel,
                           Provider<GridPanelBuilder> gridPanel,
                           Provider<ImageButtonBuilder> button,
                           Provider<ImageBuilder> image) {
        super(uiMessages, popup);

        container = relativePanel.get()
                .style(styles.container())
                .prepare(image.get()
                        .value("logo.png")
                        .style(styles.mainTitle())
                        .build())
                    .alignTop()
                    .centerHorizontally()
                    .add()
                .prepare(gridPanel.get()
                        .style(styles.mainMenu())
                        .columns(2)
                        .add(serverLogin = button.get()
                                .value(uiMessages.serverLogin())
                                .image("server_login.png")
                                .build())
                        .add(styleDemo =  button.get()
                                .value(uiMessages.styleDemo())
                                .image("style_demo.png")
                                .build())
                        .add(layoutDemo = button.get()
                                .value(uiMessages.layoutDemo())
                                .image("layout_demo.png")
                                .build())
                        .add(pushDemo = button.get()
                                .value(uiMessages.pushDemo())
                                .image("push_demo.png")
                                .build())
                        .add(timerDemo = button.get()
                                .value(uiMessages.timerDemo())
                                .image("timer_demo.png")
                                .build())
                        .add(bindingDemo = button.get()
                                .value(uiMessages.bindingDemo())
                                .image("binding_demo.png")
                                .build())
                        .build())
                    .centerHorizontally()
                    .centerVertically()
                    .add()
                .build();
    }

    @Override
    public HasClickHandler getServerLogin() {
        return serverLogin;
    }

    @Override
    public HasClickHandler getStyleDemo() {
        return styleDemo;
    }

    @Override
    public HasClickHandler getLayoutDemo() {
        return layoutDemo;
    }

    @Override
    public HasClickHandler getPushDemo() {
        return pushDemo;
    }

    @Override
    public HasClickHandler getTimerDemo() {
        return timerDemo;
    }

    @Override
    public HasClickHandler getBindingDemo() {
        return bindingDemo;
    }

    @Override
    public Object asNative() {
        return container.asNative();
    }
}
