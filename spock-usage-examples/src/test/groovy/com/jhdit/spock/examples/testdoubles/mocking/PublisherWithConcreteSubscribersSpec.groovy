package com.jhdit.spock.examples.testdoubles.mocking

import spock.lang.Specification

import java.util.logging.Logger

class PublisherWithConcreteSubscribersSpec extends Specification {

    def "without any test doubles"() {
        /*
        def publisher = new Publisher()
        publisher.subscribers << new EmailChannelSubscriber()
        publisher.subscribers << new SmsChannelSubscriber()
        */
        def publisher = setupPublisher([new EmailChannelSubscriber(), new SmsChannelSubscriber()])


        when:
            publisher.send("Newsletter")

        then:
            publisher.getMessageCount() == 2
    }

    /**
     * Mocking of non-interface types requires a code generation library (e.g. byte-buddy or cglib on the class path).
     */

    def "mock System.out.println"() {
        setup:
            def publisher = setupPublisher([new EmailChannelSubscriber(), new SmsChannelSubscriber()])
            PrintStream mockOut = mockSystemOut()

        when:
            publisher.send("Dummy message!")

        then:
            publisher.getMessageCount() == 2

        and:
            // 2 * out.println(_)
            1 * mockOut.println("Pretend we're implemented email distribution functionality here! Sending: Dummy message!")
            1 * mockOut.println("Pretend we're implemented SMS distribution functionality here! Sending: Dummy message!")
    }

    private PrintStream mockSystemOut() {
        PrintStream mockOut = Mock()
        System.setOut(mockOut)
        mockOut
    }

    def "mock logging within test collaborators"() {
        setup:
            def concreteSubscribers = [new EmailChannelSubscriber(), new SmsChannelSubscriber()]
            def mockLogger = mockOutLogging(concreteSubscribers)
            def publisher = setupPublisher(concreteSubscribers)

        when:
            publisher.send("Dummy message!")

        then:
            publisher.getMessageCount() == 2

        and:
            2 * mockLogger.info("Received: Dummy message!")
    }

    private Logger mockOutLogging(List<Subscriber> subscribers) {
        def mockLogger = Mock(Logger)
        subscribers.each() {
            it.logger = mockLogger
        }
        mockLogger
    }

    def "mock concrete subscribers"() {
        setup:
            EmailChannelSubscriber mockEmailSubscriber = Mock()
            def mockSmsSubscriber = Mock(SmsChannelSubscriber)
            def publisher = setupPublisher([mockEmailSubscriber, mockSmsSubscriber])
            def testMsg = "Mocking concrete subscribers"

        when:
            publisher.send(testMsg)

        then:
            1 * mockEmailSubscriber.receive(testMsg)
            1 * mockSmsSubscriber.receive(testMsg)
    }

    private Publisher setupPublisher(List<Subscriber> subscribers) {
        def publisher = new Publisher()
        subscribers.each() {
            publisher.subscribers << it
        }
        return publisher
    }
}
