package com.jhdit.spock.examples.old

import spock.lang.Specification
import spock.lang.Subject

class StateChangeSpec extends Specification {

    void "use old to check prior state"()   {
        @Subject
        def list = [1,2,3] // ArrayList
        // assert list.size() == 3 // Use old() instead

        when: "addition of an additional entry"
            list << 4

        then: "current & prior state are as expected"
            list.size() == 4
            old( list.size() ) == 3
    }

    void "use old to check map key change"()    {
        def map = [:]
            map.example = "initial"

        when:
            map.example = "updated"

        then:
            map.example == "updated"
            old(map.example) == "initial"
            map.example != old(map.example)
    }
}
