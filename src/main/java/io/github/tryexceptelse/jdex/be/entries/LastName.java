package io.github.tryexceptelse.jdex.be.entries;

/**
 * Represents a Contact's last name.
 * Child of ContactNameEntry, which is itself a child of ContactEntry
 */
public class LastName extends ContactNameEntry{
    /**
     * Default constructor for LastName.
     */
    public LastName() {
        super();
    }

    /**
     * Constructor for LastName with passed string to be initialized with.
     * @param entryString: String to be stored as last name.
     */
    public LastName(String entryString) {
        super(entryString);
    }
}
