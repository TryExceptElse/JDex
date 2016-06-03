package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.ContactEntry;
import io.github.tryexceptelse.jdex.be.entries.ContactNotes;

import java.io.Serializable;
import java.util.HashMap;

/**
 * One object of this class represents one contact to be added to the list
 * storing contacts.
 */
public class Contact implements IContact, Serializable
{
    private HashMap<String, ContactEntry> entries; // HashMap storing Contact's entries.

    /**
     * Default constructor for Contact.
     * Stores empty map of entries.
     */
    public Contact(){
        // placeholder
    }

    /**
     * Constructor for Contact using passed HashMap of entries to be
     * stored within.
     * @param entries: HashMap of ContactEntry object to be stored.
     */
    public Contact(HashMap<String, ContactEntry> entries)
    {
        // skeleton placeholder
    }

    /**
     * Sets entry of String key name to value String
     * @param key: String key to store value in.
     * @param entry: ContactEntry to store with key.
     */
    public void setEntry(String key, ContactEntry entry){
        // skeleton placeholder
    }

    /**
     * Gets entry stored with key String.
     * @param key: key String to retrieve data with
     */
    public ContactEntry getEntry(String key){
        return new ContactNotes(); // placeholder.
        // should return appropriate entry from entries
    }
}
