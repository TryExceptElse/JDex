package io.github.tryexceptelse.jdex.tests.be;

import io.github.tryexceptelse.jdex.be.Contact;

import io.github.tryexceptelse.jdex.be.entries.ContactEntry;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.HashMap;

/**
 * Tests Contact object to ensure entries can be set and retrieved successfully
 */
public class TestContact extends TestCase{

    private Contact contact;

    /** create contact with test values */
    protected void setUp(){
        contact = new Contact(new HashMap<String, ContactEntry>(){{
            put("testKey1", Mockito.mock(ContactEntry.class));
            put("testKey2", Mockito.mock(ContactEntry.class));
        }});
    }

    protected void tearDown(){
        contact = null;
    }

    public void testSetEntryDoesNotRaiseError(){contact.setEntry("testKey3", Mockito.mock(ContactEntry.class));}

    public void testGetEntryDoesNotRaiseError(){contact.getEntry("testKey1");}

    public void testNewFieldsCanBeStoredThenRetrievedFromContact(){
        ContactEntry newEntry1 = Mockito.mock(ContactEntry.class);
        ContactEntry newEntry2 = Mockito.mock(ContactEntry.class);
        contact.setEntry("newEntry1", newEntry1);
        contact.setEntry("newEntry2", newEntry2);
        TestCase.assertEquals(contact.getEntry("newEntry1"), newEntry1);
        TestCase.assertEquals(contact.getEntry("newEntry2"), newEntry2);
    }

    public void testEntriesInContactCanBeOverwrittenTest(){
        ContactEntry newEntry1 = Mockito.mock(ContactEntry.class);
        ContactEntry newEntry2 = Mockito.mock(ContactEntry.class);
        contact.setEntry("entry1", newEntry1);
        TestCase.assertEquals(newEntry1, contact.getEntry("entry1"));
        contact.setEntry("entry1", newEntry2);
        TestCase.assertEquals(newEntry2, contact.getEntry("entry1"));
    }
}
