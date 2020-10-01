package com.jhdit.spock

/**
 * Simple Unit test/specification to confirm Spock test framework is functioning correctly (&amp; for quick reference).
 *
 * See https://code.google.com/p/spock/wiki/HelloSpock
 * and https://code.google.com/p/spock/wiki/SpockBasics
 *
 * Spock blocks:
 * -------------
 *
 * given: preconditions, data fixtures
 * setup: alias for given (JUnit syntax)
 * when: actions that trigger some outcome
 * then: make assertions about the outcome
 * expect: shorthand for when & then
 * where: applies varied inputs
 * and: subdivides other blocks
 * cleanup: post-conditions, housekeeping
 *
 *
 * Execution via Gradle:
 * ---------------------
 *
 * gradle cleanTest test -Dtest.single=IsSpockWorking
 */

import spock.lang.*

@Unroll
class IsSpockWorkingSpec extends Specification {
    // Fields
    def unsharedResource = "NOT shared between features, recreated each time"
    @Shared
    def sharedResource = "Too expensive to keep creating"

    // Fixture methods
    def setup() {}          // run before every feature method
    def cleanup() {}        // run after every feature method
    def setupSpec() {}     // run before the first feature method
    def cleanupSpec() {}   // run after the last feature method

    // Feature methods

    /**
     * Data table (in 'where' block) example
     */

    @Unroll
    def "size matches expected length for #word"() {

        expect: "size matches word length"
            word.size() == length

        where: "test data"
            word                                            || length
            "Spock"                                         || 5
            "Antidisestablishmentarianism"                  || 28
            "Supercalifragilisticexpialidocious"            || 34
            "Pneumonoultramicroscopicsilicovolcanoconiosis" || 45
    }

    /**
     * Exception handling example (NB: must be in 'then' block)
     */

    def "divide by zero"() {
        when: "silly division"
            1 / 0

        then: "ensure expected exception raised"
            final ArithmeticException e = thrown()
            e.message == "Division by zero"
    }

    /**
     * Show-case use of FailsWith annotation
     */

    @FailsWith(ArithmeticException)
    def "alternative divide by zero"() {
        given: "silly division"
            1 / 0
    }

    /**
     * Test exclusion example
     */

    @Ignore(value = "TODO")
    def "ignore for now"() {
        expect: "will fail for now"
            true == false
    }

    def "test unshared and shared"() {
        expect:
            assert this.unsharedResource == "NOT shared between features, recreated each time"
            assert this.sharedResource == "Too expensive to keep creating"

        cleanup: "Modify for subsequent test"
            this.unsharedResource = "Changed"
            this.sharedResource = "Changed"
    }

    def "retest unshared and shared"() {
        expect: "shared resource modified, assuming feature method that alters it excuted previously"
            assert this.unsharedResource == "NOT shared between features, recreated each time"
            assert this.sharedResource == "Changed"
    }

}