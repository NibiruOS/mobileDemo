package org.nibiru.mobile.demo.client.core.api.business.security;

import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import javax.annotation.Nullable;

public class Session {
	private UserDto user;

	public UserDto getUser() {
		return user;
	}

	public void setUser(@Nullable UserDto user) {
		this.user = user;
	}
}
