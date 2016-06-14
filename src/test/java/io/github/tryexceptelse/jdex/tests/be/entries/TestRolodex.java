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
    public void testCheckAddContactIfGivenContactObject() throws InvalidObjectException
    {
        Rolodex test_contacts = new Rolodex();
        Contact test_contact = new Contact(new FirstName("Bob") , new LastName("Glassey"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        test_contacts.addContact(test_contact);
        assertTrue(test_contacts.getContacts().get(0).equals(test_contact));
    }

    /**
     * checks if addContact works when given parameters working parmeters rather than an object
     */
    public void testCheckAddContactIfGivenParameters() throws InvalidObjectException
    {
        Rolodex test_contacts = new Rolodex();
        test_contacts.addContact(new FirstName("Bob"), new LastName("Glassey"),
                new EmailAddress("testemail@testing.com"), new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes"));

        assertTrue(test_contacts.getContacts().get(0).getFirst().equals("Bob"));
    }
    /**
     * checks if Search works when given a LastName contained by one of the objects
     */
    public void testSearch() throws InvalidObjectException
    {
        Rolodex test_contacts = new Rolodex();
        Contact test_contact = new Contact(new FirstName("Bob") , new LastName("Glassey"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
                test_contacts.addContact(test_contact);
        ArrayList<Contact> expectedSearchResults = new ArrayList<>();
        expectedSearchResults.add(test_contact);

        assertEquals(expectedSearchResults, test_contacts.search(new LastName ("Glassey")));
    }
    public void testSortContacts() throws InvalidObjectException
    {
        Rolodex test_contacts = new Rolodex();
        Contact test_contact_1 = new Contact(new FirstName("Bob") , new LastName("Glassey"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        Contact test_contact_2 = new Contact(new FirstName("Phill") , new LastName("Thomas"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        Contact test_contact_3 = new Contact(new FirstName("Joe") , new LastName("Bob"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        Contact test_contact_4 = new Contact(new FirstName("Andrew") , new LastName("Thomas"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        Contact test_contact_5 = new Contact(new FirstName("Magnus") , new LastName("Carlsson"),
                new EmailAddress("testemail@testing.com"),new StreetAddress("1870 University ave"),
                new PhoneNumber("(650-862-1418"), new ContactNotes("no notes") );
        test_contacts.addContact(test_contact_1);
        test_contacts.addContact(test_contact_2);
        test_contacts.addContact(test_contact_3);
        test_contacts.addContact(test_contact_4);
        test_contacts.addContact(test_contact_5);
        test_contacts.sortContacts();
        ArrayList<Contact> correct_order_contacts = new ArrayList<Contact>();
        correct_order_contacts.add(test_contact_3);
        correct_order_contacts.add(test_contact_5);
        correct_order_contacts.add(test_contact_1);
        correct_order_contacts.add(test_contact_4);
        correct_order_contacts.add(test_contact_2);
        assertEquals(test_contacts.getContacts(),correct_order_contacts);
    }
}
