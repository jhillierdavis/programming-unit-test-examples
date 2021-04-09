package com.jhdit.java.learning.exceptions;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Explore auto-closure (implicit, rather than explicit closing of resources) using try-with-resources approach.
 *
 * NB: try-with-resources also referred to as try with parameters.
 */

public class TryWithResourcesExamples {

    public static final String TEST_TEXT_FILE = "com/jhdit/java/learning/exceptions/Test-Text-File.txt";

    private File getResourceFile(String filename)   {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(filename).getFile());
    }

    @Test
    void withoutAutoClosureForComparisonExample() {
        // Setup: a file reader
        WrappedBufferedReader in = null;

        // When: a file is read & the reader is explicitly closed
        try {
            in = new WrappedBufferedReader(new FileReader(getResourceFile(TEST_TEXT_FILE)));
            assertFalse(in.isClosed());
            String text = in.readLine();
            assertEquals("Some text for testing purposes!", text);
        } catch (FileNotFoundException fnfe) {
            System.out.printf("Failed to read text line from file %s%n", fnfe);
        } catch (IOException ioe) {
            System.out.printf("Error opening file %s%n", ioe);
        } catch (Exception e) {
                System.out.printf("Runtime exception accessing file %s%n", e);
        } finally {
            try {
                in.close();
            } catch (Exception e)   {
                System.out.printf("Error closing file %s%n", e);
            }
        }

        // Then: call of close is confirmed (via wrapper class)
        assertTrue(in.isClosed());
    }

    @Test
    void withAutoClosureAndSuppressedExceptionsExample()  {
        // Setup: a file reader reference
        WrappedBufferedReader wrappedBufferedReader = null;

        // When: a file is read & the reader is implicitly closed
        try (WrappedBufferedReader in = new WrappedBufferedReader(new FileReader(getResourceFile(TEST_TEXT_FILE)))) {
            String text = in.readLine();
            assertEquals("Some text for testing purposes!", text);
            wrappedBufferedReader = in;
            assertFalse(wrappedBufferedReader.isClosed());
        } catch (FileNotFoundException fnfe) {
            System.out.printf("Failed to read text line from file %s%n", fnfe);
        } catch (IOException ioe) {
            System.out.printf("Error opening file %s%n", ioe);
        } catch (Exception e) {
            System.out.printf("Runtime exception accessing file %s%n", e);

            // Handle suppressed exceptions (thrown in the implicitly formed finally block
            Throwable[] suppressedExceptions = e.getSuppressed();
            for (final Throwable suppressedException: suppressedExceptions) {
                System.out.printf("Suppressed exception %s%n", suppressedException);
            }
        }
        // NB: No need for explicit close of resources in a finally block!

        // Then: call of close is confirmed (via wrapper class)
        if (null == wrappedBufferedReader) {
            fail();
        }
        assertTrue(wrappedBufferedReader.isClosed());
    }
}

/**
 * Wrapper class simply used to determine whether BufferedReader is closed.
 * NB: since do not know of a way to determine this directly via BufferedReader itself.
 */

class WrappedBufferedReader implements AutoCloseable  {
    private boolean isClosed = false;
    private final BufferedReader bufferedReader;

    WrappedBufferedReader(FileReader fileReader)    {
        this.bufferedReader = new BufferedReader(fileReader);
    }

    String readLine()   throws IOException {
        return this.bufferedReader.readLine();
    }

    @Override
    public void close() throws IOException {
        this.bufferedReader.close();
        this.isClosed = true;
    }

    boolean isClosed()  {
        return isClosed;
    }
}
