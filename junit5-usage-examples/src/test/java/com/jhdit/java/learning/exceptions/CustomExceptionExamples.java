package com.jhdit.java.learning.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Explore definition & use of custom exceptions (both checked & unchecked/runtime)
 */

public class CustomExceptionExamples {

    @Test
    void exploreCustomRuntimeException() {
        assertThrows(CustomRuntimeException.class, () -> {
            triggerCustomRuntimeException();
        });
    }

    @Test
    void exploreCustomCheckedException() {
        try {
            triggerCustomCheckedException();
            fail(); // Fail test is reach this statement!
        } catch (CustomCheckedException cce) {
            System.out.printf("Expected checked exception caught %s%n", cce);
        }
    }

    void triggerCustomRuntimeException() {
        throw new CustomRuntimeException("Custom runtime (unchecked) exception");
    }

    void triggerCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException("Custom checked exception");
    }
}


class CustomCheckedException extends Exception {
    CustomCheckedException(String message) {
        super(message);
    }
}

class CustomRuntimeException extends RuntimeException {
    CustomRuntimeException(String message) {
        super(message);
    }
}

