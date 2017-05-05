package org.nibiru.mobile.demo.client.core.api.business.security;


public class InvalidCredentialsException extends SecurityException {
    public InvalidCredentialsException() {
        super("Invalid credentials");
    }
}
