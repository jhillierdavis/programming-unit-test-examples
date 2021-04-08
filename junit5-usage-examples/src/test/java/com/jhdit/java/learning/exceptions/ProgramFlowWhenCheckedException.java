package com.jhdit.java.learning.exceptions;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exploration of program flow when checked exception thrown.
 */

public class ProgramFlowWhenCheckedException {

    @Test
    void exploreProgramWithCheckedExceptionThatMustBeHandledOrDeclaredThrown()   {
        String prefix = "exploreProgramWithCheckedExceptionThatMustBeHandledOrDeclaredThrown sequence:";
        try {
            triggerCheckedException(prefix);
            checkNotReached();
        } catch (NoSuchFileException nsfe) {
            System.out.printf("%s caught checked exception %s%n", prefix, nsfe);
        } catch (IOException ioe) {
            checkNotReached();
        } catch (Exception e) {
            checkNotReached();
        } finally {
            System.out.printf("%s 'finally' action executed%n", prefix);
        }
        System.out.printf("%s last statement action executed%n", prefix);
    }

    private void triggerCheckedException(String prefix) throws IOException {
        System.out.printf("%s triggerCheckedException() method executed%n", prefix);
        throw new NoSuchFileException("No file!"); // NB:  NoSuchFileException extends IOException
    }

    private void checkNotReached()    {
        fail(); // Fail the unit test if reached
    }
}
