package io.github.tryexceptelse.jdex.be.entries;

/**
 * Represents phone number entry for a Contact.
 */
public class PhoneNumber extends ContactEntry{
    /**
     * Default constructor for PhoneNumber.
     */
    public PhoneNumber() {
        super();
    }

    /**
     * Constructor with passed String to be stored.
     * @param entryString: String for PhoneNumber entry to be initialized with.
     */
    public PhoneNumber(String entryString) {
        super(entryString);
    }
}
