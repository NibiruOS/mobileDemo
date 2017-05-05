package org.nibiru.mobile.demo.shared.service.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.nibiru.mobile.demo.shared.api.service.security.UserDto;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

@JsonIgnoreProperties(value = { "location" })
public class UserDtoImpl implements UserDto {
    private String barcode;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private int location;

    @Inject
    public UserDtoImpl() {
    }

    public UserDtoImpl(String barcode,
                       String firstName,
                       String lastName,
                       int location) {
        this.barcode = checkNotNull(barcode);
        this.firstName = checkNotNull(firstName);
        this.lastName = checkNotNull(lastName);
        this.location = location;
    }

    @Override
    public String getBarcode() {
        return barcode;
    }

    @Override
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getLocation() {
        return location;
    }

    @Override
    public void setLocation(int location) {
        this.location = location;
    }
}
