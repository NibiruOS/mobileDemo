package org.nibiru.mobile.demo.client.core.impl;

import org.nibiru.mobile.core.api.app.EntryPoint;
import org.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import org.nibiru.mobile.core.api.ui.place.PlaceManager;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AppEntryPoint implements EntryPoint {
	private final PlaceManager placeManager;

	@Inject
	public AppEntryPoint(PlaceManager placeManager) {
		this.placeManager = checkNotNull(placeManager);
	}

	@Override
	public void onApplicationStart() {
		placeManager.createPlace(DefaultPlaces.HOME).go();
	}
}
