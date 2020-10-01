package com.jhdit.spock.examples.datadriven

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SingleColumnSpec extends Specification {

    def "test with single column data - index equals value: #i"() {
        given: "a test list"
            def list = [0, 1, 2, 3, 4, 5, 6, 7]

        expect: "entry matches offset"
            i == list[i]

        where: '''data tables MUST have at least 2 columns,
                  so use underscore wildcard'''
            i | _
            1 | _
            7 | _
            0 | _
    }
}
