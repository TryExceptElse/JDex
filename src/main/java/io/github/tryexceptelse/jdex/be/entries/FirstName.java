package io.github.tryexceptelse.jdex.be.entries;

/**
 * represents contact's first name
 */
public class FirstName extends ContactNameEntry {

    /**
     * Default constructor for FirstName
     */
    public FirstName() {
        super();
    }

    /**
     * Constructor for First Name, using passed String entry.
     * @param entryString: String to be stored as first name.
     */
    public FirstName(String entryString){
        super(entryString);
    }
}
