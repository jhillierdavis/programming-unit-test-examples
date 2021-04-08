package com.jhdit.java.learning.exceptions;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exploration of program flow when runtime exception thrown.
 */

public class ProgramFlowWhenRuntimeException {

    @Test
    void exploreProgramFlowCatchingRuntimeException()   {
        String prefix = "exploreProgramFlowCatchingRuntimeException sequence:";
        try {
            triggerRuntimeException(prefix);
            checkNotReached();
        } catch (IOException ioe) {
            checkNotReached();
        } catch (Exception e) {
            System.out.printf("%s caught runtime exception %s%n", prefix, e);
        } finally {
            System.out.printf("%s 'finally' action executed%n", prefix);
        }
        System.out.printf("%s last statement action executed%n", prefix);
    }

    @Test
    void exploreProgramFlowNotCatchingRuntimeException()   {
        assertThrows(NullPointerException.class, () -> {
            flowNotCatchingRuntimeException();
        });
    }

    private void flowNotCatchingRuntimeException() {
        String prefix = "flowNotCatchingRuntimeException sequence:";
        try {
            triggerRuntimeException(prefix);
            checkNotReached();
        } catch (IOException ioe)   {
            checkNotReached();
        } finally {
            System.out.printf("%s 'finally' action executed%n", prefix);
        }
        checkNotReached();
    }

    private void triggerRuntimeException(String prefix) throws IOException {
        System.out.printf("%s triggerRuntimeException() method executed%n", prefix);
        if (true)   {
            throw new NullPointerException();
        }
        throw new IOException();
    }

    private void checkNotReached()    {
        fail(); // Fail the unit test if reached
    }
}
