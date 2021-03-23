package com.jhdit.java.learning.classes.generics;

/**
 * Simple wrapper class as an example of use of Java Generics
 * @param <T> type to wrap
 */

class GenericWrapper<T> {
    private T objectType;

    GenericWrapper(T objectType)    {
        if (null == objectType) {
            throw new IllegalArgumentException("NULL objectType parameter");
        }
        this.objectType = objectType;
    }

    T unwrap()  {
        return this.objectType;
    }
}
