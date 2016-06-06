package io.github.tryexceptelse.jdex.be.entries;

/**
 * Abstract class representing a name field.
 * Inherited from by first and last name.
 */
abstract class ContactNameEntry extends ContactEntry {
    /**
     * Default constructor for ContactNameEntry.
     */
    public ContactNameEntry() {
        super();
    }

    /**
     * Constructor for NameEntry which stores a passed String in
     * initialized NameEntry.
     * @param entryString: String to be stored in new NameEntry.
     */
    ContactNameEntry(String entryString){
        super(entryString);
    }
}
