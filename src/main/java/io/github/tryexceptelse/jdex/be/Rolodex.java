package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Stores and operates on Contacts
 */
public class Rolodex implements IRolodex
{

    private ArrayList<Contact> contacts; // program's main contacts list
    private File contactsFile; // file object referencing program save location
    private static final File DEFAULT_FILE = new File(Rolodex.class.
            getClassLoader().getResource("contacts.ser").getPath());

    /**
     * Default constructor for Rolodex.
     * Should use default file location
     */
    public Rolodex()
    {
        // skeleton placeholder.
    }

    /**
     * Constructor for Rolodex using passed File to load from
     * and use for saving.
     *
     * @param contactsFile: File to load from and eventually save to on
     *                      program close
     */
    public Rolodex(File contactsFile)
    {
        this.contactsFile = contactsFile;
        contacts = loadContacts();
    }

    /**
     * Sets Rolodex's list of contacts.
     *
     * @param newContacts: ArrayList of Contacts to store.
     */
    public void setContacts(ArrayList<Contact> newContacts) {
        contacts = newContacts;
    }

    /**
     * Returns all objects contained in ArrayList
     *
     * @return ArrayList of Contacts
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param first:      expects FirstName object representing the first name of the contact
     * @param last:       expect LastName object representing the last name of the contact
     * @param email:      expects EmailAddress object representing the email address of the contact
     * @param streetAddr: expects EmailAddress object represnting the email address of the contact
     * @param phone:      expects PhoneNumber object representing the phone number of the contact
     * @param notes:      expects ContactNotes object representing notes for the contact
     */

    public Contact addContact(FirstName first,
                              LastName last,
                              EmailAddress email,
                              StreetAddress streetAddr,
                              PhoneNumber phone,
                              ContactNotes notes)
                              throws InvalidObjectException
    {
        // Checking to make sure all passed fields are valid. The methods are defined in their own classes
        for (ContactEntry entry : new ContactEntry[]{first, last, email, streetAddr, phone, notes})
        {
            if (!entry.checkHasValidString())
                throw new InvalidObjectException(entry + "was invalid. Could not add to contacts");
        }
        //adding contact to the contatcs ArrayList
        contacts.add(new Contact(first, last, email, streetAddr, phone, notes));
        return new Contact();
    }

    /**
     *
     * @param searchedName: expects object of LastName class
     * @return: will return an ArrayList contating all objects with a last name that match the given LastName.
     */
    public ArrayList<Contact> search(LastName searchedName)
    {
        // skeleton placeholder. ArrayList should be populated with matches here.
        return contacts.stream().filter(contact -> contact.getLast() == searchedName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void saveContacts()
    {
        // skeleton placeholder. Contacts should be saved to contactsFile.
    }

    public ArrayList<Contact> loadContacts()
    {
        // placeholder. ArrayList of Contacts should be loaded from contactsFile.
        return new ArrayList<>();
    }
}