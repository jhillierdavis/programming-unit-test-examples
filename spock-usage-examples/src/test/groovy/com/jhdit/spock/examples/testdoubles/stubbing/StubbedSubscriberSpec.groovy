package com.jhdit.spock.examples.testdoubles.stubbing

import com.jhdit.spock.examples.testdoubles.mocking.Publisher
import spock.lang.Specification;

import com.jhdit.spock.examples.testdoubles.mocking.Subscriber
import spock.lang.Subject

class StubbedSubscriberSpec extends Specification {
    @Subject // Annotation for information only
    Publisher publisher = new Publisher()

    /**
     * A Stub is a fake class that can be programmed with custom behavior.
     * NB: Doesn't have a test subject - just here to explore stub behaviour
     */

    def "stubbing (Subscriber)"() {
        Subscriber stub = Stub(Subscriber)
        stub.receive(_) >>> [true, false, true] // Alternate boolean return value

        expect:
            stub.receive("1st event") == true
            stub.receive("2nd event") == false // Will fail if not false
            stub.receive "3rd event" // True implicitly expected
    }

    def "publisher counts successful message delivery"() {
        setup: "stub out subscriber response sequence to emulate failure"
            Subscriber stubbedSubscriber = Stub()
            stubbedSubscriber.receive(_) >>> [true, false, true]
            publisher.subscribers << stubbedSubscriber

        when: "a series of messages are published"
            publisher.send "1st message"
            publisher.send "2nd message" // Stubbed to fail delivery
            publisher.send "3rd message"

        then: "only successful subscriber transfers are counted"
            publisher.messageCount == 2
    }
}
