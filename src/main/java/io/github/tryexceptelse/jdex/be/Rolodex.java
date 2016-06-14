package io.github.tryexceptelse.jdex.be;
import io.github.tryexceptelse.jdex.be.entries.*;
import java.io.*;
import java.util.*;
import java.util.Comparator;

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
     * adds contact to list being given Contact object to add to contacts, and sorts contacts by lastName then firstName
     * @param contact: contact you want to add to list
     * @return the contact that was added, for ease of modification
     */
    public Contact addContact(Contact contact)throws InvalidObjectException
    {
        if (contact.checkParametersAreValid())
        {
            contacts.add(contact);
            Collections.sort(contacts);
            return contact;
        }
        throw new InvalidObjectException("contact could not be added because one or more of the feilds was invalid");
    }
    /**
     * adds contact to list, being given each  attribute then sorts contacts by lastName then firstName
     * @param first:      expects FirstName object representing the first name of the contact
     * @param last:       expect LastName object representing the last name of the contact
     * @param email:      expects EmailAddress object representing the email address of the contact
     * @param streetAddr: expects EmailAddress object represnting the email address of the contact
     * @param phone:      expects PhoneNumber object representing the phone number of the contact
     * @param notes:      expects ContactNotes object representing notes for the contact
     * @return will return the contact that was added, for ease of modification
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
            Collections.sort(contacts);
            return  contact;
        }
        throw new InvalidObjectException("contact could not be added because one or more of the fields was invalid");
    }
    /**
     *
     * @param searchedName: expects object of LastName class
     * @return will return an ArrayList containing all objects with a last name that match the given LastName.
     */
    public ArrayList<Contact> search(LastName searchedName)
    {
        ArrayList<Contact> searchedContacts = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++)
        {
            if (contacts.get(i).getLast().equals(searchedName))
            {
                searchedContacts.add(contacts.get(i));
            }
        }
        return searchedContacts;
    }

    /**
     * Sorts contacts List by LastName, then FirstName using compareTo method defined in Contact class.
     */
    public void sortContacts()
    {
        Collections.sort(contacts);
    }

    /**
     * Saves contacts to contactsFile in serializble form
     */
    public void saveContacts(){
        try {
            FileOutputStream fileOut = new FileOutputStream(contactsFile);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(contacts);
            fileOut.close();
            objOut.close();
        } catch (IOException IOE) {
            System.out.println("Error saving contacts to file");
            IOE.printStackTrace();
        }
    }
    /**
     * Default load contacts method
     * @return ArrayList with Contacts.
     */
    public ArrayList<Contact> loadContacts(){
        return loadContacts(DEFAULT_FILE);
    }

    /**
     * Loads contacts from contactsFile
     * @param contactsFile: File object representing file in which
     *                    contacts are stored.
     * @return ArrayList with Contacts.
     */
    public ArrayList<Contact> loadContacts(File contactsFile){
        ArrayList<Contact> newContacts = new ArrayList<>();
        try
        {
            FileInputStream fileIn = new FileInputStream(contactsFile);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            Object loadedObject = objIn.readObject();
            if (!(loadedObject instanceof ArrayList)) {
                throw new IOException("Object retrieved from serializable was not an ArrayList");
            }
            newContacts = (ArrayList<Contact>) loadedObject;
            objIn.close();
            fileIn.close();
        }catch(IOException IOE){
            System.out.println("Error loading contacts from file.");
            IOE.printStackTrace();
            System.out.println("Continuing with empty contacts list.");
        }catch(ClassNotFoundException noClass){
            System.out.println("Could not read contacts object from file");
            noClass.printStackTrace();
            System.out.println("Continuing with empty contacts list.");
        }
        return newContacts;
    }
}