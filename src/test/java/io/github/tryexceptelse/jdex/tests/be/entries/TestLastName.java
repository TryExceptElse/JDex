package io.github.tryexceptelse.jdex.tests.be.entries;

import io.github.tryexceptelse.jdex.be.entries.LastName;
import junit.framework.TestCase;

/*
I am using this test class to do a quick intro to test writing.
 */
/**
 * Tests methods and functionality of LastName entry.
 */
// extending TestCase, imho, is the easiest and most effective testing method.
public class TestLastName extends TestCase{
    // these methods can be protected in scope.
    /** set up method which is run before each test. */
    protected void setUp(){ // this does nothing here, it's just an example
    }

    /** method called after each test to clean up. */
    protected void tearDown(){
    }

    /*
    Yes, these are ridiculously long method names.
    Yes, that is normal for tests.
    No-one actually types in the method to call it, so it's no inconvenience.
    When a test fails, the first thing that is displayed is the test method
    name, and sometimes when there's no javadoc, it's the only explanation
    of what the test is doing or is supposed to indicate.

    These methods need to be public in scope in order to be called by the test
    program.
    */
    /**
     * Test checkStringIsValid returns true when passed valid, non-empty
     * String.
     */
    public void testCheckStringIsValidReturnsTrueForValidLastName(){
        assertTrue(LastName.checkStringIsValid("Doe"));
        // assertTrue, assertFalse, and assertEquals are the most commonly
        // used methods of TestCase.
    }

    /** Test checkStringIsValid returns false when passed empty string. */
    public void testCheckStringIsValidReturnsFalseForEmptyString(){
        assertFalse(LastName.checkStringIsValid(""));
    }

    /** Test checkStringIsInvalid returns false when passed string of spaces.*/
    public void testCheckStringIsValidReturnsFalseForStringOfSpaces(){
        assertFalse(LastName.checkStringIsValid("                          "));
    }
    /*
     There are more tests that could be written for this method and others in
     LastName.
     Ideally, one test is present for each possible course (if-branch for
     example) which the program could take through the method being tested.
      */

}
