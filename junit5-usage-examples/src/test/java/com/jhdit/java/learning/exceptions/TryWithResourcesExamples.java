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
        File file = new File(classLoader.getResource(filename).getFile());
        return file;
    }

    @Test
    void withoutAutoClosure() {
        Boolean closed = false;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(getResourceFile(TEST_TEXT_FILE)));
            String text = in.readLine();
            assertEquals("Some text for testing purposes!", text);
        } catch (FileNotFoundException fnfe) {
            System.out.printf("Failed to read text line from file%n", fnfe);
        } catch (IOException ioe) {
            System.out.printf("Error opening file%n", ioe);
        } finally {
            try {
                in.close();
                closed = true;
            } catch (IOException ioe)   {
                System.out.printf("Error closing file%n", ioe);
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
            System.out.printf("Failed to read text line from file%n", fnfe);
        } catch (IOException ioe) {
            System.out.printf("Error opening file%n", ioe);
        }
    }
}
