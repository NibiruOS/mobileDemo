package org.nibiru.mobile.demo.client.core.impl.service.security;

import com.google.common.net.MediaType;
import org.nibiru.mobile.demo.client.core.api.service.security.SecurityService;
import org.nibiru.mobile.demo.shared.api.service.Paths;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import org.nibiru.async.core.api.promise.Promise;
import org.nibiru.mobile.core.api.http.HttpException;
import org.nibiru.mobile.core.api.http.HttpMethod;
import org.nibiru.mobile.core.api.service.RemoteService;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class SecurityServiceImpl implements SecurityService {
    private final RemoteService service;

    @Inject
    public SecurityServiceImpl(RemoteService service) {
        this.service = checkNotNull(service);
    }

    @Override
    public Promise<UserDto, HttpException> login(UserDto dto) {
        return service.invoke(Paths.LOGIN, dto, UserDto.class, HttpMethod.PUT, MediaType.JSON_UTF_8);
    }
}
