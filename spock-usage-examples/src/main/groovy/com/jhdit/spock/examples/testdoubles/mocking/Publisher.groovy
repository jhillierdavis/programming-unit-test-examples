package com.jhdit.spock.examples.testdoubles.mocking

/**
 * Responsible for publishing messages out to a list of associated subscribers.
 * Counts successfully sent messages.
 */

class Publisher {
    List<Subscriber> subscribers = []

    int messageCount = 0 // total count of successfully send messages

    void send(String message) {
        def results = subscribers*.receive(message) // Use spread operator
        messageCount += results.count (true)
    }
}