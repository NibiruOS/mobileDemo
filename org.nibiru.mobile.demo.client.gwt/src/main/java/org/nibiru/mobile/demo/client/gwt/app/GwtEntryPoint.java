package org.nibiru.mobile.demo.client.gwt.app;

import com.google.gwt.core.client.EntryPoint;

public class GwtEntryPoint implements EntryPoint {
	@Override
	public void onModuleLoad() {
		DaggerInjector.create().getBootstrap().onBootstrap();
	}
}
