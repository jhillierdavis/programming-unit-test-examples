package com.jhdit.spock.examples.testdoubles.mocking

import spock.lang.Specification

class PublisherWithSingleMockSubscriberSpec extends Specification {

    def "published messages are received by a single subscriber"() {
        setup: "mock collaborator and create subject under test/spec"
            def mockSubscriber = Mock(Subscriber)
            def concretePublisher = new Publisher()
            concretePublisher.setSubscribers([mockSubscriber])

        when:
            concretePublisher.send("Mix as follows:")
            concretePublisher.send("Cement")
            concretePublisher.send("Cement")
            concretePublisher.send("Water")
            concretePublisher.send("Goodbye!")

        then:
            2 * mockSubscriber.receive("Cement") >> true
            3 * mockSubscriber.receive(!"Cement") >> true // or: 3 * mockSubscriber.receive(_) >> true

        and:
            5 == concretePublisher.getMessageCount()
    }

    void "published messages are received by a single mock subscriber with failures"() {

        setup: "mock collaborator and create subject under test/spec"
            Subscriber mockSubscriber = Mock()
            def concretePublisher = new Publisher()
            concretePublisher.subscribers << mockSubscriber

        when: "a series of messages are sent"
            ["Mix as follows:", "Cement", "Cement", "Water", "Goodbye!"].each {
                concretePublisher.send(it)
            }

        then: "mock subscriber receives expected messages (interactions as expected)"
            2 * mockSubscriber.receive("Cement") >> true
            1 * mockSubscriber.receive("Goodbye!") >> false // Emulate failure
            2 * mockSubscriber.receive(_) >> true // Underscore (wildcard) param covers remainder

        and: "overall message count is as expected"
            4 == concretePublisher.getMessageCount()
    }
}
