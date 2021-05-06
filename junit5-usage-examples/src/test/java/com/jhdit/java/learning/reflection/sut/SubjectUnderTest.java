package com.jhdit.java.learning.reflection.sut;

public class SubjectUnderTest {
    private String opaque = "Something hidden is revealed!";
    public String transparent = "Available to all";

    public String getPublicInfo()   {
        return "Public: " + this.transparent;
    }

    private String getPrivateInfo() {
        return "Private: " + this.opaque;
    }
}
