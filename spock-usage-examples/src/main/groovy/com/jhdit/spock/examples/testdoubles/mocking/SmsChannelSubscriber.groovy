package com.jhdit.spock.examples.testdoubles.mocking

import java.util.logging.Logger

class SmsChannelSubscriber implements Subscriber, ChannelDistributor {
    Logger logger = Logger.getLogger(this.getClass().getName())

    boolean receive(String msg)    {
        logger.info("Received: ${msg}")
        return distribute(msg)
    }

    boolean distribute(String msg) {
        System.out.println "Pretend we're implemented SMS distribution functionality here! Sending: ${msg}"
        return true
    }
}
