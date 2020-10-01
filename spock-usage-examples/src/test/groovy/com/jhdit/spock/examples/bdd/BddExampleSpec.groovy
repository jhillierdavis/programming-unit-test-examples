package com.jhdit.spock.examples.bdd

import spock.lang.Specification

/**
 * Example of block usage for BDD (Behavior-Driven Dev.) approach.
 */

class BddExampleSpec extends Specification {

    def "blocks are optional"()   {
        assert true
    }

    def "multiple blocks"() {
        given: "one thing"
        and: "another thing"
        and: "yet another thing"
        when: "I open my eyes"
        then: "I see something"
        and: "I don't see something else"
    }
}