package com.jhdit.spock.examples.javascript

import spock.lang.*
import javax.script.*

/**
 * JavaScript execution example
 */

class JavaScriptSpec extends Specification {
    @Shared ScriptEngine engine

    def setupSpec() {
        def manager = new ScriptEngineManager()
        engine = manager.getEngineByName("nashorn")
        if (null == engine) {
            throw new RuntimeException("Failed to instantiate JavaScript engine!")
        }
    }

    def "can call a named JS function"()   {
        given:
            engine.eval  '''
                function up(s)  {
                    return s.toUpperCase();
                }
            '''

        expect:
            (engine as Invocable).invokeFunction("up", "upper") == "UPPER"
    }

}
