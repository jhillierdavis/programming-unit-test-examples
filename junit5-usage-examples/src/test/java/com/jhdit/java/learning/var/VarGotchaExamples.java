package com.jhdit.java.learning.var;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VarGotchaExamples {

    @Test
    void varIsNotAKeyword() {
        // 'var' CAN be used as variable name (for backward compatibility!) - although not recommended
        int var = 10;
        var value = 10;

        assertEquals(var, value);
    }

    @Test
    void inferredAsInteger() {
        // Given: a primitive byte for subsequent comparison with var usage
        byte flags = 0;

        // Then: variable 'flags' is primitive of type byte (checked via conversion to wrapper class equivalent)
        assertTrue(((Object) flags) instanceof Byte);

        // Given: a var then need to be careful about inferred type (as may not be as expect)
        var flagsUsingVar = 0; // inferred as integer type (not byte!)

        // Then: type is inferred as Integer by default (e.g. not byte)
        assertFalse(((Object) flagsUsingVar) instanceof Byte);
        assertTrue(((Object) flagsUsingVar) instanceof Integer);

        // Instead: (if want var as a byte) use:
        var flagsUsingVarAsByte = (byte) 0; // a cast
        assertTrue(((Object) flagsUsingVarAsByte) instanceof Byte);
    }

    @Test
    void inferredAsDouble() {
        // Given: a primitive double for subsequent comparison with var usage
        double value = 2.0;

        // Then: variable 'value' is a primitive of type double (checked via conversion to wrapper class equivalent)
        assertTrue(((Object) value) instanceof Double);

        // Given: a var then need to be careful about inferred type (as may not be as expect)
        var valueUsingVar = 2.0; // inferred as integer type (not byte!)

        // Then: type is inferred as Integer by default (e.g. not byte)
        assertFalse(((Object) valueUsingVar) instanceof Float);
        assertTrue(((Object) valueUsingVar) instanceof Double);

        // Instead: (if want var as a float) use:
        var valueUsingVarAsFloat = 2.0F;
        assertTrue(((Object) valueUsingVarAsFloat) instanceof Float);
    }

}
