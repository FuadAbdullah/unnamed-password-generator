package PasswordGenerator;

import java.lang.Throwable;

public class ShortLengthException extends Exception {
    ShortLengthException() {
        super();
    }

    ShortLengthException(String errorMessage) {
        super(errorMessage);
    }

    ShortLengthException(Throwable err) {
        super(err);
    }

    ShortLengthException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}