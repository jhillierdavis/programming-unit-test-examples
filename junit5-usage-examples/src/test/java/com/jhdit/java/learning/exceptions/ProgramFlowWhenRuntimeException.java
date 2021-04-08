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
    void exploreProgramFlow()   {
        assertThrows(NullPointerException.class, () -> {
            try {
                foo();
                notReached();
            } catch (IOException ioe)   {
                notReached();
            } finally {
                System.out.println("Sequence: 'finally' action executed");
            }
            notReached();
        });
    }

    private void foo() throws IOException {
        System.out.println("Sequence: foo() method executed");
        if (true)   {
            throw new NullPointerException();
        }
        throw new IOException();
    }

    private void notReached()    {
        fail(); // Fail the unit test if reached
    }
}
