package io.github.tryexceptelse.jdex.be.entries;
import javax.mail.Address;
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

    public static boolean checkStringIsValid(String entryString)
    {
        if(!ContactEntry.checkStringIsValid(entryString))
            return false;
        if (entryString=="")
            return true;
        //iterates through each char of the string until it finds an @, then it iterates through the string until it
        // finds a '.'. If the String has a '.' after the '@', returns true.
        boolean atfound=false;
        for (int i = 0 ; i < entryString.length() ; i++)
        {
            char c = entryString.charAt(i);
            if (c== '@')
            {
                atfound=true;
            }
            if(c =='.' && atfound)
            {
                return true;
            }
        }
        return false;
    }
}
