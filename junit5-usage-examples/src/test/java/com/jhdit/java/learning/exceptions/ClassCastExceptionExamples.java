package com.jhdit.java.learning.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Examples of the RuntimeException ClassCastException.
 */

public class ClassCastExceptionExamples {

    @Test
    void explore()  {
        WebBrowsers.Browser browser = new WebBrowsers.Firefox();

        assertThrows(ClassCastException.class, () -> {
            WebBrowsers.Safari safari =  (WebBrowsers.Safari) browser;
                });
    }
}


class WebBrowsers {
    static class Browser {
        public void render() {}
    }

    static class Firefox extends Browser {
        public void render() {}
    }

    static class Safari extends Browser {
        public void render() {}
    }
}
