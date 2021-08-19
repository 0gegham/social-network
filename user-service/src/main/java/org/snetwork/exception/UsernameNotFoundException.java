package org.snetwork.exception;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String msg) {
        super(msg);
    }

    public UsernameNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
