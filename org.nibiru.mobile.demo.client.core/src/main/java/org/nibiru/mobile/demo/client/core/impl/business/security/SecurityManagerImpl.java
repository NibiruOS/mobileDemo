package org.nibiru.mobile.demo.client.core.impl.business.security;

import org.nibiru.mobile.demo.client.core.api.business.security.InvalidCredentialsException;
import org.nibiru.mobile.demo.client.core.api.business.security.SecurityException;
import org.nibiru.mobile.demo.client.core.api.business.security.SecurityManager;
import org.nibiru.mobile.demo.client.core.api.business.security.Session;
import org.nibiru.mobile.demo.client.core.api.service.security.SecurityService;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import org.nibiru.async.core.api.promise.Promise;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class SecurityManagerImpl implements SecurityManager {
    private final SecurityService securityService;
    private final Provider<UserDto> userDtoProvider;
    private final Provider<Session> sessionProvider;

    @Inject
    public SecurityManagerImpl(SecurityService securityService,
                               Provider<UserDto> userDtoProvider,
                               Provider<Session> sessionProvider) {
        this.securityService = checkNotNull(securityService);
        this.userDtoProvider = checkNotNull(userDtoProvider);
        this.sessionProvider = checkNotNull(sessionProvider);
    }

    @Override
    public Promise<Boolean, SecurityException> login(String barcode) {
        checkNotNull(barcode);

        UserDto dto = userDtoProvider.get();
        dto.setBarcode(barcode);
        return securityService.login(dto)
                .map(result -> {
                    sessionProvider.get().setUser(result);
                    return true;
                })
                .mapError(exception -> exception != null
                            && exception.getStatus() != null
                            && exception.getStatus().is4xxClientError()
                        ? new InvalidCredentialsException()
                        : new SecurityException(exception));
    }
}
