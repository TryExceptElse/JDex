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

    /**
     *
     * @param entryString: phoneNumber String to be checked
     * @return: checks if phoneNumber contains letters, returns false if it does, true if it doesn't
     */
    public static boolean checkStringIsValid(String entryString)
    {
        for(int i=0; i<entryString.length(); i++)
        {
            char c=entryString.charAt(i);
            if((c>'a' && c<= 'z') || (c >= 'A' && c <= 'Z'))
            {
                return false;
            }
        }
        return true;
    }
}
