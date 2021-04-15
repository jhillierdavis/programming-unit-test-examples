package com.jhdit.java.learning.classes.staticimports;

import org.junit.jupiter.api.Test;

// Static imports
import static com.jhdit.java.learning.classes.staticimports.sports.Football.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticImportExamples {

    @Test
    void explore()  {
        assertEquals(11, TEAM_SIZE);
    }
}


