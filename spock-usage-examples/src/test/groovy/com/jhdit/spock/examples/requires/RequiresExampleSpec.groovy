package com.jhdit.spock.examples.requires

import spock.lang.Specification
import spock.lang.Requires

class RequiresExampleSpec extends Specification {

    @Requires({jvm.java8})
    def "JVM languages as stream (ignored if not >= Java 8)"()    {

        def jvmLanguages = ["Java", 'Groovy', 'Scala', 'Kotlin']

        expect:
            jvmLanguages.stream().findFirst().get() == 'Java'
    }
}
