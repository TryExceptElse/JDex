package io.github.tryexceptelse.jdex.be.entries;

/**
 * Represents a street address to be stored with Contact
 */
public class StreetAddress extends ContactEntry {
    /**
     * Default constructor for StreetAddress entry.
     */
    public StreetAddress() {
        super();
    }

    /**
     * Constructs a StreetAddress object storing passed address.
     * @param addressString: String address to be stored.
     */
    public StreetAddress(String addressString) {
        super(addressString);
    }
}
