package com.jhdit.spock.examples.testdoubles.spying

import spock.lang.Specification

class WhatIsSpock {
    protected String prefix() {
        "Specification"
    }

    String description() {
        this.prefix() + " + Mocking"
    }
}

class SpySpec extends Specification {
    def "partially mock"() {
        setup:
            def spy = Spy(WhatIsSpock)

        when:
            def result = spy.description()
            println result

        then:
            result == "Spy + Mocking"

        and:
            1 * spy.prefix() >> "Spy"
    }
}
