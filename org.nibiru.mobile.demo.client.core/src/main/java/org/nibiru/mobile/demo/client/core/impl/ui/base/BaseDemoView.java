package org.nibiru.mobile.demo.client.core.impl.ui.base;

import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.impl.builder.PopupBuilder;

import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseDemoView implements DemoView {
	private final Popup loadingIndicator;

	public BaseDemoView(UiMessages uiMessages,
                        Provider<PopupBuilder> popup) {
		checkNotNull(uiMessages);
		loadingIndicator = popup.get().loadingPopup(uiMessages.loading()); 
	}

	@Override
	public void showLoadingIndicator() {
		loadingIndicator.show();
	}

	@Override
	public void hideLoadingIndicator() {
		loadingIndicator.hide();
	}
}
