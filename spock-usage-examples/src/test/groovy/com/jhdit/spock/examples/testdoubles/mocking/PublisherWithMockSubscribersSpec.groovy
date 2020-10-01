package com.jhdit.spock.examples.testdoubles.mocking

import spock.lang.Specification

class PublisherWithMockSubscribersSpec extends Specification {
    def TEST_MESSAGE = "Test message!"
    Publisher publisher = new Publisher()
    Subscriber subscriber1 = Mock()
    Subscriber subscriber2 = Mock()
    Subscriber notSubscribed = Mock()

    def setup() {
        publisher.subscribers << subscriber1 // << is a Groovy shorthand for List.add()
        publisher.subscribers << subscriber2

        // Verify that no messages have yet been sent
        publisher.getMessageCount() == 0
    }

    def "a message sent is received by all subscribers (only)"() {
        when: "a test message is published"
            publisher.send(TEST_MESSAGE)

        then: "subscribers receive the message (once only)"
            // cardinality specifies exactly one call
            1 * subscriber1.receive(TEST_MESSAGE) >> true
            1 * subscriber2.receive(TEST_MESSAGE) >> false

        and: "those not subscribed do not"
            0 * notSubscribed.receive(TEST_MESSAGE)

        and: "the successfully published message count is as expected"
            publisher.getMessageCount() == 1
    }

}