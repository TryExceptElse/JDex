package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
     * Should use default file location, or generate empty ArrayList
     */
    public Rolodex()
    {
        contacts = new ArrayList<>();
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
        contacts = new ArrayList<>(); //placeholder until we implement Load function.
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
     * adds contact to list being given Contact object to add
     * @param: contact contact you want to add to list
     * @return: the contact that was added, for ease of modification
     */
    public Contact addContact(Contact contact)throws InvalidObjectException
    {
        if (contact.checkParametersAreValid())
        {
            contacts.add(contact);
            return contact;
        }
        throw new InvalidObjectException("contact could not be added because one or more of the feilds was invalid");
    }
    /**
     * adds contact to list, being given each  attribute.
     * @param first:      expects FirstName object representing the first name of the contact
     * @param last:       expect LastName object representing the last name of the contact
     * @param email:      expects EmailAddress object representing the email address of the contact
     * @param streetAddr: expects EmailAddress object represnting the email address of the contact
     * @param phone:      expects PhoneNumber object representing the phone number of the contact
     * @param notes:      expects ContactNotes object representing notes for the contact
     * @return: will return the contact that was added, for ease of modification
     */
    public Contact addContact(FirstName first,
                              LastName last,
                              EmailAddress email,
                              StreetAddress streetAddr,
                              PhoneNumber phone,
                              ContactNotes notes)
                              throws InvalidObjectException
    {
        //adding contact to the contacts ArrayList if its parameters are valid
        Contact contact = new Contact(first, last, email , streetAddr , phone , notes);
        if(contact.checkParametersAreValid())
        {
            contacts.add(contact);
            return  contact;
        }
        throw new InvalidObjectException("contact could not be added because one or more of the fields was invalid");
    }

    /**
     *
     * @param searchedName: expects object of LastName class
     * @return: will return an ArrayList contating all objects with a last name that match the given LastName.
     */
    public ArrayList<Contact> search(LastName searchedName)
    {
        // skeleton placeholder. ArrayList should be populated with matches here.
        return new ArrayList<>();
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