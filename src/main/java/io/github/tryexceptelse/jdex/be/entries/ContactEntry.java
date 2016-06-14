package io.github.tryexceptelse.jdex.be.entries;

import io.github.tryexceptelse.jdex.be.Contact;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * An entry in a Contact.
 * Inherited from by more specific subclasses.
 */
public abstract class ContactEntry implements Serializable{
    private static final String DEFAULT_INVALID_STRING_MESSAGE =
            "String does not meet entry requirements";
    private String entryString;

    /**
     * Default constructor for ContactEntry. Takes no args, stores empty String
     * in Entry.
     */
    public ContactEntry(){
        entryString = "";
    }

    /**
     * Constructor for ContactEntry which takes a String as argument and stores
     * it as the Entry's string.
     * @param entryString: String to be stored.
     */
    public ContactEntry(String entryString){
        this.entryString = entryString;
    }

    /**
     * Returns string representation of entry instance.
     * @return String to represent instance.
     */
    public String toString(){
        return entryString;
    }

    /**
     * Returns boolean of whether currently stored string is a valid
     * entry
     * @return boolean of whether string is a valid entry
     */
    public boolean checkHasValidString(){
        Class thisClass = this.getClass();
        try{
            Method checkMethod = thisClass.getMethod(
                    "checkStringIsValid", String.class);
            return (boolean)checkMethod.invoke(null, entryString);
        } catch (Exception e){
            System.out.println("Error: Could not access checkStringIsValid method");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns boolean of whether or not passed string is valid for this entry
     * @param string: String to be evaluated for validity.
     * @return boolean of whether passed string is valid.
     */
    public static boolean checkStringIsValid(String string){
        // children should replace this method with something useful.
        return true;
    }

    /**
     * Compares two objects of ContactEntry, to determine equality.
     * As represented here in ContactEntry, this is similar to default
     * equals method for Strings, but is not case sensitive.
     */
    public boolean equals(Object obj){
        return true; // placeholder
    }

    /**
     * Returns feedback for the user on why a given string is not valid,
     * or any other feedback to be given about the string.
     * @return String feedback, or null, if nothing is to be displayed.
     */
    public static String getStringFeedback(String string){
        return DEFAULT_INVALID_STRING_MESSAGE; // placeholder
    }
    /**
     * Gets string stored in entry.
     * @return String stored in entry.
     */
    public String getEntryString(){
        return this.entryString;
    }

    /**
     * Sets contact entry to new String.
     * @param newEntryString: New String to be stored.
     */
    public void setEntryString(String newEntryString){
        this.entryString = newEntryString;
    }
}
