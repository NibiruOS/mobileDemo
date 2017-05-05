package org.nibiru.mobile.demo.client.core.impl.ioc;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.nibiru.mobile.demo.shared.api.service.StatusDto;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;
import org.nibiru.mobile.demo.shared.service.StatusDtoImpl;
import org.nibiru.mobile.demo.shared.service.security.UserDtoImpl;

import org.nibiru.mobile.core.api.config.BaseUrl;
import org.nibiru.mobile.java.serializer.jackson.JacksonSerializer;

import dagger.Module;
import dagger.Provides;

@Module
public class DemoJavaModule {
    @Provides
    @BaseUrl
    public String baseUrl() {
        return "http://10.1.12.124:8080/org.nibiru.mobile.demo.server/";
    }

    @Provides
    public JacksonSerializer serializer(ObjectMapper mapper) {
        return new JacksonSerializer(mapper);
    }

    @Provides
    public ObjectMapper objectMapper(com.fasterxml.jackson.databind.Module jacksonModule) {
        ObjectMapper jacksonMapper = new ObjectMapper();
        jacksonMapper.registerModule(jacksonModule);
        // MOE needs changing this parameter
        jacksonMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return jacksonMapper;
    }

    @Provides
    public com.fasterxml.jackson.databind.Module jacksonModule() {
        SimpleModule jacksonModule = new SimpleModule("Demo", new Version(1,
                0,
                0,
                "SNAPSHOT",
                "org.nibiru.mobile.demo.client.core",
                "jackson"));
        jacksonModule.addAbstractTypeMapping(StatusDto.class, StatusDtoImpl.class);
        jacksonModule.addAbstractTypeMapping(UserDto.class, UserDtoImpl.class);
        return jacksonModule;
    }

    @Provides
    public StatusDto statusDto(StatusDtoImpl dto) {
        return dto;
    }


    @Provides
    public UserDto userDto(UserDtoImpl dto) {
        return dto;
    }
}
