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
        List<String> expectedMethods = Arrays.asList("getPublicInfo", "getPrivateInfo");

        // When: methods are inspected via reflection
        Method[] methods = SubjectUnderTest.class.getDeclaredMethods();
        List<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }

        // Then: the methods names gathered by reflection are as expected
        assertTrue(methodList.containsAll(expectedMethods));
        assertEquals(2, methodList.size());
    }

    @Test
    public void listPublicMethodNames() {
        // Given: the expected set of public methods names for a SUT (Subject Under Test)
        List<String> expectedPublicMethods = Arrays.asList("getPublicInfo");

        // When: public methods are inspected via reflection
        Method[] methods = SubjectUnderTest.class.getDeclaredMethods();
        List<String> methodList = new ArrayList<>();
        for(Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                methodList.add(method.getName());
            }
        }

        // Then: the methods names gathered by reflection are as expected (public only!)
        assertTrue(methodList.containsAll(expectedPublicMethods));
        assertEquals(1, methodList.size());
        assertFalse(methodList.contains("getPrivateInfo"));
    }

    @Test
    public void listPrivateMethodNames()    {
        // Given: the expected set of public methods names for a SUT (Subject Under Test)
        List<String> expectedPrivateMethods = Arrays.asList("getPrivateInfo");

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
        assertEquals(1, methodList.size());
        assertFalse(methodList.contains("getPublicInfo"));
    }


}
