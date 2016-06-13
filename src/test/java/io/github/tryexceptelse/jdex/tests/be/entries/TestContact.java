package io.github.tryexceptelse.jdex.tests.be.entries;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.entries.*;
import junit.framework.TestCase;

/**
 * Created by Entreri on 6/10/16.
 */
public class TestContact extends TestCase
{
    /**
     * checks to see if checkParmetersAreValid returns true when given valid Parameters
     */
    public void testCheckParametersAreValidForValidLastName()
    {
        Contact test_contact = new Contact(new FirstName("Bob") , new LastName("Glassey"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        assertTrue(test_contact.checkParametersAreValid());
    }
}
