package com.jhdit.spock.examples.testdoubles.mocking

/**
 * Contract for subscribers to adhere to.
 */

interface Subscriber {

    /**
     * Take receipt of a message
     * @param message
     * @return Success or failure
     */

    boolean receive(String message)
}
