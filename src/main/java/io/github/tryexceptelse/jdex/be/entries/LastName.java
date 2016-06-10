package io.github.tryexceptelse.jdex.be.entries;

/**
 * Represents a Contact's last name.
 * Child of ContactEntry
 */
public class LastName extends ContactEntry{
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

    /**
     *
     * @param entryString: the String to be checked
     * @return: will return False if string is empty, or just contains ' ' chars.
     */
    public static boolean checkStringIsValid(String entryString)
    {
        if(!ContactEntry.checkStringIsValid(entryString))
           return false;
        if (entryString==null)
            return false;
        //iterates through each char of the String and checks if it is a ' '. If one of them is not, returns true
        for (int i = 0 ; i < entryString.length() ; i++)
        {
             if (entryString.charAt(i)!= ' ')
             {
                 return true;
             }
        }
        return false;
    }
}
