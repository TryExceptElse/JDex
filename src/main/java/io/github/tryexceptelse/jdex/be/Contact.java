package io.github.tryexceptelse.jdex.be;
import java.io.Serializable;
import java.util.HashMap;
/**
 * one object of this class represents one contact to be added to the list storing contacts.
 * This class was written by Marcus Edholm
 */
public class Contact implements IContact, Serializable
{
    private HashMap<String, String> entries = new HashMap<>();;

    /**
     * Default constructor for Contact.
     */
    public Contact()
    {

    }

    /**
     * Contact constructor will set key and values. Value will contain all of the data.
     * @param entries:  data entries for contact to be created with
     */
    public Contact(HashMap<String, String> entries)
    {
        this.entries=entries;
    }

    /**
     * How to change the key for an object
     * @param key: What the key for the contact will be
     * @param value: All of the parameters to be stored will be.
     */
    public void setKey(String key, String value)
    {
        entries.put(key,value);
    }

    /**
     *
     * @param key: key to retrieve data with
     * @return: will return value stored at key
     */
    public String getEntry(String key)
    {
        return entries.get(key);
    }
    public String toString()
    {
        String nameString = "{";
        for (String key:entries.keySet())
        {
            if (nameString.length() == 1) nameString += ", ";
            String value = entries.get(key);
            nameString+=key + ": " + value;
        }
        nameString += "}";
        return nameString;
    }

}
