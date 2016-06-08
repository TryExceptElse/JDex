package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.*;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Java Rolodex interface
 */
public interface IRolodex
{
    /** Returns all objects contained in ArrayList
     *
     * @return ArrayList of Contacts
     */
    ArrayList<Contact> getContacts();

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
                              ContactNotes notes) throws InvalidObjectException;


    /**
     *
     * @param searchedName: expects object of LastName class
     * @return: will return an ArrayList contating all objects with a last name that match the given LastName.
     */
    public ArrayList<Contact> search(LastName searchedName);

    /**
     * Serializes contacts list and saves it to drive
     */
    void saveContacts();

    /** Loads contact list from drive and returns it.
     * @return contacts ArrayList
     */
    ArrayList<Contact> loadContacts();
}
