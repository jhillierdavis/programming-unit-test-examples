package com.jhdit.spock.examples.testdoubles.mocking

import java.util.logging.Logger

class EmailChannelSubscriber implements Subscriber, ChannelDistributor {
    Logger logger = Logger.getLogger(EmailChannelSubscriber.getName())

    boolean receive(String msg)    {
        logger.info("Received: ${msg}")
        return distribute(msg)
    }

    boolean distribute(String msg) {
        System.out.println "Pretend we're implemented email distribution functionality here! Sending: ${msg}"
        return true
    }
}
