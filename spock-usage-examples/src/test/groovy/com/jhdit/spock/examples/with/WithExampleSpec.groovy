package com.jhdit.spock.examples.with

import spock.lang.Specification

class Person  {
    def firstname
    def surname
    def dob
}

class WithExampleSpec extends Specification{

    def "with usage example"()  {
        def person = new Person(firstname: "Santa", surname: "Claus", dob: "15/03/270")

        expect:
            with(person)    {
                firstname == "Santa"
                dob ==~ /.*270/ // Reg. exp.
            }
    }
}
