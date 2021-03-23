package com.jhdit.java.learning.classes.generics;

class ObjectWrapper {
    private Object object;

    ObjectWrapper(Object object) {
        if (null == object) {
            throw new IllegalArgumentException("NULL object parameter");
        }
        this.object = object;
    }

    Object unwrap()  {
        return this.object;
    }
}
