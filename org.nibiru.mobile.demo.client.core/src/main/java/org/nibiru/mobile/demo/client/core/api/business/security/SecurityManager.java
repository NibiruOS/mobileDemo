package org.nibiru.mobile.demo.client.core.api.business.security;

import org.nibiru.async.core.api.promise.Promise;

public interface SecurityManager {
    Promise<Boolean, SecurityException> login(String barcode);
}
