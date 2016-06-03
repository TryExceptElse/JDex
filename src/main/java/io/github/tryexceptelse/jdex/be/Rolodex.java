package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.ContactEntry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
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
     * Should use default file location
     */
    public Rolodex(){
        // skeleton placeholder.
    }

    /**
     * Constructor for Rolodex using passed File to load from
     * and use for saving.
     * @param contactsFile: File to load from and eventually save to on
     *                    program close
     */
    public Rolodex(File contactsFile){
        // skeleton placeholder
    }

    /**
     * Sets Rolodex's list of contacts.
     * @param newContacts: ArrayList of Contacts to store.
     */
    public void setContacts(ArrayList<Contact> newContacts){
        contacts = newContacts;
    }

    /** Returns all objects contained in ArrayList
     * @return ArrayList of Contacts
     */
    public ArrayList<Contact> getContacts(){
        return contacts;
    }

    /** Returns Contact after adding it to list
     *
     * @param newEntries HashMap of ContactEntries, with String keys.
     *                   This is the map of the entries that will be stored
     *                   in the new Contact object.
     * @return Contact which was added to the rolodex. This is so that the UI
     * has a reference to the newly added object, from which it may display
     * information to the user, if needed.
     */
    public Contact addContact(HashMap<String, ContactEntry> newEntries)
    {
        // placeholder. Contact should be added to contacts.
        return new Contact(newEntries);
    }

    /**
     * Returns list containing contacts that match all passed criteria.
     * @param searchCriteria: HashMap of criteria, stored with String keys,
     *                      which all contacts in contacts list are compared to
     *                      in order to determine whether they match and should
     *                      be returned to the caller.
     */
    public ArrayList<Contact> search(HashMap<String, ContactEntry> searchCriteria)
    {
        // skeleton placeholder. ArrayList should be populated with matches here.
        return new ArrayList<>();
    }

    public void saveContacts(){
        // skeleton placeholder. Contacts should be saved to contactsFile.
    }

    public ArrayList<Contact> loadContacts(){
        // placeholder. ArrayList of Contacts should be loaded from contactsFile.
        return new ArrayList<>();