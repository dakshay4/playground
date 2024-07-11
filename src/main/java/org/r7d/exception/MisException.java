package org.r7d.exception;


public class MisException extends RuntimeException {

    public MisException() {
    }

    public MisException(String message) {
        super(message);
    }

    public MisException(String message, Throwable cause) {
        super(message, cause);
    }

    public MisException(Throwable cause) {
        super(cause);
    }

    public MisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
