package com.jhdit.java.learning.identifiers;

/**
 * Legal (including unconventional) & illegal identifier examples
 *
 * Identifiers = class, variable & method names
 *
 * Rules for legal identifiers:
 *
 * * Must start with letter, currency symbol (e.g. $ or £) or connecting char. (e.g. underscore _ ).  NB: not a digit!
 * * After 1st char then any (Unicode) combination of letters, currency chars, underscores or numbers.
 * * Not a Java keyword (e.g. abstract, boolean, private etc.), including reserved keywords (e.g. goto)
 * * No practical limit to number of chars. in identifier
 *
 * NB: Identifiers in Java are case-sensitive; foo & FOO are 2 different identifiers!
 */

public class IdentifierExamples {
    // Legal identifiers (e.g. class member variables)
    private int legal = 1;
    private double AccountBalance;
    private int buttonWidth;

    // Legal, but unconventional (don't use)
    private int _underscore; //  Starts with underscore - bad form (but legal!)
    private int $doller; // Starts with dollar - bad form (but legal!)
    private int £pound_sterling;
    private int AnotherVariable; // Start with a lower-case letter by convention (unless a constant)
    private static int min_height = 100; // Use capitals by convention instead e.g. MIN_HEIGHT

    // Illegal identifiers (won't compile - hence commented out!)
    // private int 1llegal = 0; // Starts with a digit (1)
    // private int 4real = 0; // Starts with a digit (4)
    // private :b; // Does not start with letter, currency char or connecting char (e.g. underscore)
    // private -d;
    // private e#;
    // private .f;
    // private goto; // Reserved word 'goto'
    // private int hyphen-ated; // Hyphen not permitted connecting char (unlike underscore)

    // Legal method names
    private void doFoo() {}

    // Legal, but unconventional method names
    private void $Value() {}
    private void £Value() {}
    private void _Prefix() {}
    private void DoFoo() {}
    private void _underscore_separated_Method_Name() {}

    // Illegal method names (will NOT compile)
    // private void 4Play() {}
    // private void 4FooSake()  {}
    // private void hyphen-separated-Method-Name() {}
}

