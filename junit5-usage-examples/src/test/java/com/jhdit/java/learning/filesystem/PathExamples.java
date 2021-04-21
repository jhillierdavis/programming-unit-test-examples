package com.jhdit.java.learning.filesystem;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PathExamples {

    @Test
    void explorePath()  {
        Path somefile = Path.of("/", "users", "joe", "docs", "some.txt");
        assertEquals("/users/joe/docs/some.txt", somefile.toString());
        Path justSomeFile = somefile.getFileName();
        assertEquals("some.txt", justSomeFile.toString());
        Path docFolder = somefile.getParent();
        assertEquals("/users/joe/docs", docFolder.toString());
        Path currentFolder = docFolder.relativize(somefile);
        assertEquals("some.txt", currentFolder.toString());
    }
}
