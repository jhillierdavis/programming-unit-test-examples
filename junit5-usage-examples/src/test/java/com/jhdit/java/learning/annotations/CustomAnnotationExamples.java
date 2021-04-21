package com.jhdit.java.learning.annotations;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

// @Target(value = { METHOD }) // Invalid as not applied on a method in this example!
@Target(value = { FIELD, CONSTRUCTOR })
@interface CustomAnnotation {
    String owner();
    int count() default 100; // Must have a default as not specified
}


class Store    {
    public String desc;

    @CustomAnnotation(owner = "Sam")
    public Store(String desc)  {
        this.desc = desc;
    }
}

public class CustomAnnotationExamples {
}
