package com.jhdit.java.learning.classes.initialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Explore enumeration initialisation (which differs from typical static -> instance -> constructor order)
 */

enum Outcome {
    FAILURE, SUCCESS;

    static {
        System.out.println("Static initializer block");
    }

    {
        System.out.println("Instance initializer block for " + this);
    }

    Outcome() {
        System.out.println("Constructor initializer block for: " + this);
    }
}

public class EnumInitialisationOrderExamples {
    @Test
    void explore() {
        Outcome outcome = Outcome.SUCCESS;

        switch(outcome) {
            default:
            case FAILURE:
                fail();
                break;

            case SUCCESS:
                assertEquals(1, outcome.ordinal());
        }
    }
}
