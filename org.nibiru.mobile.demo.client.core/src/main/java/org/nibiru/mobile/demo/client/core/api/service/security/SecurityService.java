package org.nibiru.mobile.demo.client.core.api.service.security;

import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import org.nibiru.async.core.api.promise.Promise;
import org.nibiru.mobile.core.api.http.HttpException;

public interface SecurityService {
    Promise<UserDto, HttpException> login(UserDto dto);
}
