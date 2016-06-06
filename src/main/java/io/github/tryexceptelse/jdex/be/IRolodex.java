package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.ContactEntry;

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

    /** Returns Contact after adding it to list
     *
     * @param newEntries HashMap of ContactEntries, with String keys.
     *                   This is the map of the entries that will be stored
     *                   in the new Contact object.
     * @return Contact which was added to the rolodex. This is so that the UI
     * has a reference to the newly added object, from which it may display
     * information to the user, if needed.
     */
    Contact addContact(HashMap<String, ContactEntry> newEntries);


    /**
     * Returns list containing contacts that match all passed criteria.
     * @param searchCriteria: HashMap of criteria, stored with String keys,
     *                      which all contacts in contacts list are compared to
     *                      in order to determine whether they match and should
     *                      be returned to the caller.
     */
    ArrayList search(HashMap<String, ContactEntry> searchCriteria);

    /**
     * Serializes contacts list and saves it to drive
     */
    void saveContacts();

    /** Loads contact list from drive and returns it.
     * @return contacts ArrayList
     */
    ArrayList<Contact> loadContacts();
}
