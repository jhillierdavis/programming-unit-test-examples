package com.jhdit.spock.examples.sharedstate

import spock.lang.Shared
import spock.lang.Specification

class SharedExampleSpec extends Specification {
    // Fields
    def unsharedResource = "NOT shared between features, recreated each time"
    @Shared
    def sharedResource = "Too expensive to keep creating"

    def "test unshared and shared"() {
        expect:
            assert this.unsharedResource == "NOT shared between features, recreated each time"
            assert this.sharedResource == "Too expensive to keep creating"

        cleanup: "Modify for subsequent test"
            this.unsharedResource = "Changed"
            this.sharedResource = "Changed"
    }

    def "retest unshared and shared"() {
        expect: "shared resource modified, assuming feature method that alters it excuted previously"
            assert this.unsharedResource == "NOT shared between features, recreated each time"
            assert this.sharedResource == "Changed"
    }
}
