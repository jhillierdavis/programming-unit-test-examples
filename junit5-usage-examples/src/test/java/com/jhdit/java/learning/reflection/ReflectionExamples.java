package com.jhdit.java.learning.reflection;

import com.jhdit.java.learning.reflection.sut.SubjectUnderTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic usage of reflection examples.
 */

public class ReflectionExamples {

    @Test
    public void listAllDeclaredMethodNames()    {
        // Given: the expected set of methods names for a SUT (Subject Under Test)
        List<String> expectedMethods = Arrays.asList("getPublicInfo", "getPrivateInfo", "echo");

        // When: methods are inspected via reflection
        Method[] methods = SubjectUnderTest.class.getDeclaredMethods();
        List<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }

        // Then: the methods names gathered by reflection are as expected
        assertTrue(methodList.containsAll(expectedMethods));
        assertEquals(3, methodList.size());
    }

    @Test
    public void listPublicMethodNames() {
        // When: public methods are inspected via reflection
        Method[] methods = SubjectUnderTest.class.getDeclaredMethods();
        List<String> methodList = new ArrayList<>();
        for(Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                methodList.add(method.getName());
            }
        }

        // Then: the methods names gathered by reflection are as expected (public only!)
        assertTrue(methodList.contains("getPublicInfo"));
        assertEquals(1, methodList.size());
        assertFalse(methodList.contains("getPrivateInfo"));
        assertFalse(methodList.contains("echo"));
    }

    @Test
    public void listPrivateMethodNames()    {
        // Given: the expected set of public methods names for a SUT (Subject Under Test)
        List<String> expectedPrivateMethods = Arrays.asList("getPrivateInfo", "echo");

        // When: public methods are inspected via reflection
        Method[] methods = SubjectUnderTest.class.getDeclaredMethods();
        List<String> methodList = new ArrayList<>();
        for(Method method : methods) {
            if (Modifier.isPrivate(method.getModifiers())) {
                methodList.add(method.getName());
            }
        }

        // Then: the methods names gathered by reflection are as expected (public only!)
        assertTrue(methodList.containsAll(expectedPrivateMethods));
        assertEquals(2, methodList.size());
        assertFalse(methodList.contains("getPublicInfo"));
    }

    @Test
    public void invokePublicMethod() throws Exception {
        // Given: a public method
        Method method = SubjectUnderTest.class.getDeclaredMethod("getPublicInfo");

        // When: invoke private method
        String returnValue = (String) method.invoke(new SubjectUnderTest());

        // Then: the method can be invoked!
        assertEquals("Public: Available to all", returnValue);
    }

    @Test
    public void invokePrivateMethodWithoutParams() throws Exception {
        // Given: a private method
        Method method = SubjectUnderTest.class.getDeclaredMethod("getPrivateInfo");

        // Setup: allow private method to be invoked
        method.setAccessible(true);

        // When: invoke private method
        String returnValue = (String) method.invoke(new SubjectUnderTest());

        // Then: the method can be invoked!
        assertEquals("Private: Something hidden is revealed!", returnValue);
    }

    @Test
    public void invokePrivateMethodWithParams() throws Exception {
        // Given: a private method
        Method method = SubjectUnderTest.class.getDeclaredMethod("echo", String.class);

        // Setup: allow private method to be invoked
        method.setAccessible(true);

        // When: invoke private method
        String returnValue = (String) method.invoke(new SubjectUnderTest(), "Test parameter");

        // Then: the method can be invoked!
        assertEquals("Test parameter", returnValue);
    }

}
