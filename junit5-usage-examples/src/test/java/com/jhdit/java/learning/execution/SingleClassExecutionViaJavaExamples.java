package com.jhdit.java.learning.execution;

import java.util.*;

/**
 * Can be executed directly via Java command (no need to first compile via javac for a single class that uses standard lib only)
 *
 * e.g. % java SingleClassExecutionViaJavaExamples.java
 * This works!
 * Next random number = 5
 */

public class SingleClassExecutionViaJavaExamples {
    public static void main(String[] args) {
        System.out.println("This works!");

        Random r = new Random();
        System.out.println("Next random number = " + r.nextInt(10) );
    }
}

