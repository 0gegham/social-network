package org.snetwork.exception;

public class PictureNotFoundException extends RuntimeException {
    public PictureNotFoundException(String msg) {
        super(msg);
    }

    public PictureNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
