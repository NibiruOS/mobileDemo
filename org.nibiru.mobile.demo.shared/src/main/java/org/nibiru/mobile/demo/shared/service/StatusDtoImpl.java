package org.nibiru.mobile.demo.shared.service;

import org.nibiru.mobile.demo.shared.api.service.StatusDto;

import javax.inject.Inject;

public class StatusDtoImpl implements StatusDto {
	private boolean ok;

	@Inject
	public StatusDtoImpl() {
	}

	public StatusDtoImpl(boolean ok) {
		this.ok = ok;
	}

	@Override
	public boolean isOk() {
		return ok;
	}

	@Override
	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
