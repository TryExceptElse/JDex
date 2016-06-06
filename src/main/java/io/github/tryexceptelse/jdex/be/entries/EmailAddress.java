package io.github.tryexceptelse.jdex.be.entries;

/**
 * Represents email address entry for a Contact
 */
public class EmailAddress extends ContactEntry{

    /**
     * Default constructor for EmailAddress.
     */
    public EmailAddress() {
        super();
    }

    /**
     * Constructor for emailAddress with passed String to be stored.
     * @param entryString: String to be stored.
     */
    public EmailAddress(String entryString) {
        super(entryString);
    }
}
