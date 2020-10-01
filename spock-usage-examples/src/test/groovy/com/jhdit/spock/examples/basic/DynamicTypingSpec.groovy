package com.jhdit.spock.examples.basic

import spock.lang.Specification

class DynamicTypingSpec extends Specification {

    public void trivialSum_JavaStyle()    {
        when:
            int number = 1;

        then:
            number + number == 2 * number;
    }

    void trivialSum_PublicDropped_NoSemiColons()   {
        when:
            int number = 1

        then:
            number + number == 2 * number
    }

    def trivialSum_UsingDef()   {
        when:
            int number = 1

        then:
            number + number == 2 * number
    }

    def "Trivial Sum - tested Groovy & Spock style"()   {
        when: "a number"
            int number = 1

        then: "adding to itself is doubling"
            number + number == 2 * number
    }
}
