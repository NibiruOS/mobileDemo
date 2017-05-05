package org.nibiru.mobile.demo.client.gwt.service;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import org.nibiru.mobile.demo.shared.api.service.StatusDto;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

public interface AutoBeanDtoFactory extends AutoBeanFactory {
	AutoBean<StatusDto> status();

	AutoBean<UserDto> user();
}
