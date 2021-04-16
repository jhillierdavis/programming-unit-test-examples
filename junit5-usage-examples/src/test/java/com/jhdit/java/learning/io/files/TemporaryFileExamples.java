package com.jhdit.java.learning.io.files;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Examples of temporary files in unit tests (JUnit5 specifically).
 *
 * Ref.: https://blogs.oracle.com/javamagazine/working-and-unit-testing-with-temporary-files-in-java?source=:em:nw:mt::::RC_WWMK200429P00043:NSL400149788
 */

public class TemporaryFileExamples {

    Path path1, path2;
    File file1, file2;

    /* This directory and the files created in it will be deleted after
     * tests are run, even in the event of failures or exceptions.
     */
    @TempDir
    Path tempDir;

    /* executed before every test: create two temporary files */
    @BeforeEach
    public void setUp() {
        try {
            path1 = tempDir.resolve("testfile1.txt");
            path2 = tempDir.resolve("testfile2.txt");
        } catch (InvalidPathException ipe) {
            System.err.println(
                    "error creating temporary test file in " +
                            this.getClass().getSimpleName());
        }

        file1 = path1.toFile();
        file2 = path2.toFile();
    }

    @Test
    void explore()  {
        System.out.println(path1);
        System.out.println(path2);
    }

}