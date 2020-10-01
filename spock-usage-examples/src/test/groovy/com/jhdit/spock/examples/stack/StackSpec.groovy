package com.jhdit.spock.examples.stack

import spock.lang.Specification

class StackSpec extends Specification {

    def "stack example: exception handling & multiple when-then blocks"()    {
        setup:
            def stack = new Stack() // Standard Java: java.util.Stack
            def today = new Date()

        expect:
            stack.empty()

        when:
            stack.pop()

        then:
            def e = thrown(EmptyStackException)
            e instanceof EmptyStackException

        when:
            stack.add "First entry"
            stack << [a:1, b:2, c:3] // Map
            stack.add( ['x', 'y', 'z'] ) // List
            stack << today // Last item

        then:
            !stack.empty
            stack.size() == 4
            stack.peek() == today
    }
}
