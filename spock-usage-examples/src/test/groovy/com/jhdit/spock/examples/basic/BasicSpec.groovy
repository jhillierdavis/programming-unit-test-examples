package com.jhdit.spock.examples.basic

import spock.lang.Specification

class BasicSpec extends Specification {

    // Fixture methods (optional): use Groovy assert for any checks here
    def setup() {}          // run before every feature method
    def cleanup() {}        // run after every feature method
    def setupSpec() {}     // run before the first feature method
    def cleanupSpec() {}   // run after the last feature method

    def "super simple logic example (basic multiplication)"() {
        expect:
            3.multiply(7) == 21
    }

}
