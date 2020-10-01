package com.jhdit.spock.examples.basic

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class GroovyTypeAssignmentSpec extends Specification {

    void "Implicit type is #expectedType"() {
        expect:
            value.class.is(expectedType)

        where:
            value   || expectedType
            1       || Integer
            1.0f    || Float
            1l      || Long
            1d      || Double
            '1'     || String
            "1"     || String
            '''1''' || String
    }

    void "Explicit Java primitive type converted to #expectedType"() {
        expect:
            value.class.is(expectedType)

        where:
            value         || expectedType
            1 as int      || Integer
            1.0f as float || Float
            1l as long    || Long
            1d as double  || Double
    }


    void "Explicit Java object type converted to #expectedType"() {
        expect:
            value.class.is(expectedType)

        where:
            value           || expectedType
            1 as Integer    || Integer
            1.0f as Float   || Float
            1l as Long      || Long
            1d as Double    || Double
            '' as String    || String
            new Integer(1)  || Integer
            new Float(1)    || Float
            new Long(1)     || Long
            new Double(1)   || Double
            new String('1') || String
    }
}
