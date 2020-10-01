package com.jhdit.spock.examples.datadriven

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example data table - using java.lang.Math.max()
 */

@Unroll
class MaximumSpec extends Specification {

    def "maximum of two numbers: #a , #b"() {
        expect:
            Math.max(a, b) == c

        where:
            a  | b  || c
            3  | 5  || 5
            7  | 0  || 7
            0  | 0  || 0
            -9 | -7 || -7
    }
}
