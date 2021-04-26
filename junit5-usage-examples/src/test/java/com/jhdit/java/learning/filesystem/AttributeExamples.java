package com.jhdit.java.learning.filesystem;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AttributeExamples {

    @Test
    void explore()  {
        final String HOME = System.getProperty("user.home");
        Path home = Paths.get(HOME);
        BasicFileAttributeView basicView =
                Files.getFileAttributeView(home, BasicFileAttributeView.class);

        try {
            BasicFileAttributes basicAttribs = basicView.readAttributes();
            boolean isDir = basicAttribs.isDirectory();
            assertTrue(isDir);
        } catch (IOException ioe)  {
            fail(ioe);
        }

    }
}
