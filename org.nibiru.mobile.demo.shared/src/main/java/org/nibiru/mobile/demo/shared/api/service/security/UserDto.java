package org.nibiru.mobile.demo.shared.api.service.security;

public interface UserDto {
	String getBarcode();

	void setBarcode(String barcode);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	int getLocation();

	void setLocation(int location);
}