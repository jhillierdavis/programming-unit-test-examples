package com.jhdit.spock.examples.datadriven

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example of a data driven test to exercise the same test multiple times (Spock equivalent of a parameterized test)
 *
 * NB: inputs and expected outputs can optionally be separated with a double pipe symbol (||) to visually set them apart.
 *
 * @See http://spockframework.org/spock/docs/1.0/data_driven_testing.html
 */

class PowersSpec extends Specification {

    @Unroll
    def "verify square of #base is #expectedResult"() {
        expect: "power of 2"
            Math.pow(base, 2) == expectedResult

        where: "test inputs and expected outputs as follows"
            base || expectedResult
            2    || 4
            3    || 9
            10   || 100
            -1   || 1.0
    }
}