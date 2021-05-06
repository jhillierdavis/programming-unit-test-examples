package com.jhdit.java.learning.reflection.sut;

/**
 * Test subject to use via Java reflection.
 */

public class SubjectUnderTest {
    private String opaque = "Something hidden is revealed!";
    public String transparent = "Available to all";

    public String getPublicInfo()   {
        return "Public: " + this.transparent;
    }

    private String getPrivateInfo() {
        return "Private: " + this.opaque;
    }


    private String echo(String param) {
        return param;
    }
}
