package io.github.tryexceptelse.jdex.tests.be;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.Rolodex;
import io.github.tryexceptelse.jdex.be.entries.*;
import junit.framework.TestCase;

import java.io.*;
import java.util.ArrayList;

/**
 * tests Rolodex Class to ensure all methods work properly
 */
public class TestRolodex extends TestCase{
    private Rolodex rolodex;
    private File tempFile;
    private FileOutputStream fileOut;
    private ObjectOutputStream objOut;
    private Contact testContact = new Contact(
            new FirstName("John"),
            new LastName("Doe"),
            new EmailAddress("JohnDoe@maildomain.com"),
            new StreetAddress("1234 Main Street, Anytown, USA, 123456"),
            new PhoneNumber("(123) 456-7890"),
            new ContactNotes("Example Contact")
    );

    protected void setUp() throws IOException{
        tempFile = File.createTempFile("JDex_test_temp_file", "ser");
        tempFile.deleteOnExit();
        fileOut = new FileOutputStream(tempFile);
        objOut = new ObjectOutputStream(fileOut);
        rolodex = new Rolodex(tempFile);
    }

    protected void tearDown(){
        rolodex = null;
        assert(tempFile.delete());
    }

    public void testRolodexCanBeSavedThenLoadedFromFile()
            throws InvalidObjectException{
        rolodex.addContact(testContact);
        rolodex.saveContacts(); // save contacts
        Rolodex rolodexFromSerial = new Rolodex(tempFile); // load from file
        ArrayList<Contact> contactArrayList = rolodexFromSerial.getContacts();
        // assert that a contact was loaded from file
        assertEquals("Contact list should have length 1",
                1, contactArrayList.size());
        Contact contact = contactArrayList.get(0);
        String testEntry = contact.getNotes().getEntryString();
        // assert values were stored.
        assertEquals("Contact value should be retained, and identical to " +
                "value from before saving to file.",
                "Example Contact", testEntry);
    }
}