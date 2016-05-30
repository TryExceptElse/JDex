package io.github.tryexceptelse.jdex;
/*
 * one object of this class represents one contact to be added to the list storing contacts.
 * This class was written by Marcus Edholm
 */
public class Contact
{
    private String first;
    private String last;
    private String email;
    private String streetAddr;
    private String phoneNumber;
    private String notes;

    /**
     * Will construct a new Contact, takes all of the data types as parameters  ME
     */
    public void Contact(String newFirst, String newLast, String newEmail, String newStreetAddr, String newPhoneNumber,String newNotes)
    {
        first=newFirst;
        last=newLast;
        email=newEmail;
        streetAddr=newStreetAddr;
        phoneNumber=newPhoneNumber;
        notes=newNotes;
    }
    /*
     *  can be called to set set first ME
     */
    public void setFirst(String newFirst)
    {
        first=newFirst;
    }
    /*
 *  can be called to set set last ME
 */
    public void setLast(String newLast)
    {
        last=newLast;
    }
    /*
 *  can be called to set set email ME
 */
    public void setEmai(String newEmail)
    {
        email=newEmail;
    }
    /*
 *  can be called to set set streetAddr ME
 */
    public void setStreetAddr(String newStreetAddr)
    {
        streetAddr=newStreetAddr;
    }
    /*
 *  can be called to set set phoneNumber ME
 */
    public void setPhoneNumber(String newPhoneNumber)
    {
        phoneNumber=newPhoneNumber;
    }
    /*
 *  can be called to set set notes ME
 */
    public void setNotes(String newNotes)
    {
        notes=newNotes;
    }
    /*
     *  can be called to get first  ME
     */
    public String getFirst()
    {
        return first;
    }
    /*
    *  can be called to get last  ME
    */
    public String getLast()
    {
        return last;
    }
    /*
     *  can be called to get email Me
     */
    public String getEmail()
    {
        return email;
    }
    /*
     *  can be called to get streetAddr ME
     */
    public String getstreetAddr()
    {
        return streetAddr;
    }
    /*
     *  can be called to get phoneNumber ME
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    /*
     *  can be called to get notes ME
     */
    public String getnotes()
    {
        return notes;
    }
    /*
     * Will return a string contatining all of the attributes of the object. ME
     */
    public String toString()
    {
        return null;
    }

}
