package com.jhdit.java.learning.logging;


import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Simple example of standard Java Logging
 */

public class JavaLoggingExamples {
    private static Logger logger = Logger.getLogger(com.jhdit.java.learning.logging.JavaLoggingExamples.class.getName());

    @Test
    void logInfoMessage()   {
        // When: Log level set
        logger.setLevel(Level.INFO);

        // Then: same of higher log levels are enabled
        assertTrue(logger.isLoggable(Level.SEVERE));
        assertTrue(logger.isLoggable(Level.WARNING));
        assertTrue(logger.isLoggable(Level.INFO));

        // And: lower log levels are disable
        assertFalse(logger.isLoggable(Level.CONFIG));
        assertFalse(logger.isLoggable(Level.FINE));
        assertFalse(logger.isLoggable(Level.FINER));
        assertFalse(logger.isLoggable(Level.FINEST));

        // Example: usage with guard
        if (logger.isLoggable(Level.INFO))  {
            logger.log(Level.INFO, "Informative log message!");

            // Convenience alternative
            logger.info("Informative log message via logger.info() !");
        }
    }

}
