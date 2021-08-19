package org.snetwork.exception;

public class ConversationNotFoundException extends RuntimeException {
    public ConversationNotFoundException(String msg) {
        super(msg);
    }

    public ConversationNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
