package PasswordGenerator;

public class CharacterOutOfBoundException extends Exception {
    CharacterOutOfBoundException() {
        super();
    }

    CharacterOutOfBoundException(String errorMessage) {
        super(errorMessage);
    }

    CharacterOutOfBoundException(Throwable err) {
        super(err);
    }

    CharacterOutOfBoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
