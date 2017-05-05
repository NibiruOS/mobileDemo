package org.nibiru.mobile.demo.client.core.impl.ui.base;

import org.nibiru.mobile.core.api.ui.mvp.View;

public interface DemoView extends View {
	void showLoadingIndicator();

	void hideLoadingIndicator();
}
