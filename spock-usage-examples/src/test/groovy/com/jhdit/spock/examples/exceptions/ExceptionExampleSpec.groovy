package com.jhdit.spock.examples.exceptions

import spock.lang.FailsWith
import spock.lang.Specification

class ExceptionExampleSpec extends Specification {
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
}
