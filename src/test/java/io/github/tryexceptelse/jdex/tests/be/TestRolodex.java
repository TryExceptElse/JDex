package io.github.tryexceptelse.jdex.tests.be;

import io.github.tryexceptelse.jdex.be.entries.ContactEntry;

import junit.framework.TestCase;
import org.mockito.Mockito;

import io.github.tryexceptelse.jdex.be.Rolodex;
import io.github.tryexceptelse.jdex.be.Contact;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * tests Rolodex Class to ensure all methods work properly
 */
public class TestRolodex extends TestCase{
    private Rolodex rolodex;
    private File tempFile;
    private FileOutputStream fileOut;
    private ObjectOutputStream objOut;

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

    public void testRolodexCreatesEntriesFromHashMap(){
        HashMap<String, ContactEntry> entries = new HashMap<>();
        ContactEntry testEntry1 = Mockito.mock(ContactEntry.class);
        entries.put("testKey1", testEntry1);
        rolodex.addContact(entries);
        ArrayList<Contact> contactArrayList = rolodex.getContacts();
        Contact contact = contactArrayList.get(0);
        ContactEntry testEntry = contact.getEntry("testKey1");
        TestCase.assertEquals(testEntry1, testEntry);
    }

    public void testRolodexCanBeSavedThenLoadedFromFile(){
        HashMap<String, ContactEntry> entries = new HashMap<>();
        ContactEntry entry = Mockito.mock(ContactEntry.class);
        entries.put("testKey1", entry);
        rolodex.addContact(entries);
        rolodex.saveContacts();
        Rolodex rolodexFromSerial = new Rolodex(tempFile);
        ArrayList<Contact> contactArrayList = rolodexFromSerial.getContacts();
        Contact contact = contactArrayList.get(0);
        ContactEntry testEntry = contact.getEntry("testKey1");
        TestCase.assertEquals(entry, testEntry);
    }
}