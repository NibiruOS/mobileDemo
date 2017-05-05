package org.nibiru.mobile.demo.server;

import org.nibiru.mobile.demo.shared.api.service.Paths;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;
import org.nibiru.mobile.demo.shared.service.security.UserDtoImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

@Controller
public class SecurityServiceController {
    @RequestMapping(method = RequestMethod.PUT,
            value = Paths.USER_SERVICE + "/" + Paths.LOGIN,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto login(@RequestBody UserDtoImpl dto, Device device) {
        checkNotNull(dto);
        if (Objects.equals(dto.getBarcode(), "123")) {
            return new UserDtoImpl("123", "John", device.isMobile()
                    ? "Mobile"
                    : device.isTablet()
                    ? "Tablet"
                    : "Desktop", 1);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public static class UnauthorizedException extends RuntimeException {
    }
}
