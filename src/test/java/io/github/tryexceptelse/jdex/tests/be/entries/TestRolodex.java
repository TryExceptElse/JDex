package io.github.tryexceptelse.jdex.tests.be.entries;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.Rolodex;
import io.github.tryexceptelse.jdex.be.entries.*;
import junit.framework.TestCase;

import java.io.InvalidObjectException;
import java.util.ArrayList;

/**
 * Created by Entreri on 6/10/16.
 */
public class TestRolodex extends TestCase
{
    /**
     * checks if addContact works when given Contact Object to see if it has been added
     */
    public void testCheckAddContactIfGivenContactObject()
    {
        Rolodex test_contacts = new Rolodex();
        Contact test_contact = new Contact(new FirstName("Bob") , new LastName("Glassey"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        try
        {
            test_contacts.addContact(test_contact);
        } catch(InvalidObjectException i)
        {}
        assertTrue(test_contacts.getContacts().get(0).equals(test_contact));
    }

    /**
     * checks if addContact works when given parameters working parmeters rather than an object
     */
    public void testCheckAddContactIfGivenParameters()
    {
        Rolodex test_contacts = new Rolodex();
        try {
            test_contacts.addContact(new FirstName("Bob"), new LastName("Glassey"),
                    new EmailAddress("testemail@testing.com"), new StreetAddress("1870 University ave"),
                    new PhoneNumber("(650-862-1418"), new ContactNotes("no notes"));
        }catch (InvalidObjectException i)
        {}
        assertTrue(test_contacts.getContacts().get(0).getFirst().equals("Bob"));
    }
    /**
     * checks if Search works when given a LastName contained by one of the objects
     */
    public void testSearch()
    {
        Rolodex test_contacts = new Rolodex();
        Contact test_contact = new Contact(new FirstName("Bob") , new LastName("Glassey"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        try
        {
            test_contacts.addContact(test_contact);
        } catch(InvalidObjectException i)
        {}
        assertTrue(test_contacts.search(new LastName("Glassey")).equals(test_contacts));
    }
}
