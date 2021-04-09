package com.jhdit.java.learning.exceptions;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Explore auto-closure (implicit, rather than explicit closing of resources) using try-with-resources approach.
 */

public class TryWithResourcesExamples {

    public static final String TEST_TEXT_FILE = "com/jhdit/java/learning/exceptions/Test-Text-File.txt";

    private File getResourceFile(String filename)   {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(filename).getFile());
    }

    @Test
    void withoutAutoClosure() {
        boolean closed = false;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(getResourceFile(TEST_TEXT_FILE)));
            String text = in.readLine();
            assertEquals("Some text for testing purposes!", text);
        } catch (FileNotFoundException fnfe) {
            System.out.printf("Failed to read text line from file %s%n", fnfe);
        } catch (IOException ioe) {
            System.out.printf("Error opening file %s%n", ioe);
        } finally {
            try {
                in.close();
                closed = true;
            } catch (Exception e)   {
                System.out.printf("Error closing file %s%n", e);
            }
        }
        assertTrue(closed);
    }

    @Test
    void withAutoClosure()  {
        try (BufferedReader in = new BufferedReader(new FileReader(getResourceFile(TEST_TEXT_FILE)))) {
            String text = in.readLine();
            assertEquals("Some text for testing purposes!", text);
        } catch (FileNotFoundException fnfe) {
            System.out.printf("Failed to read text line from file %s%n", fnfe);
        } catch (IOException ioe) {
            System.out.printf("Error opening file %s%n", ioe);
        }
    }
}
