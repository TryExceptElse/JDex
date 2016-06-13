package io.github.tryexceptelse.jdex.be;
import io.github.tryexceptelse.jdex.be.entries.*;

import java.io.InvalidObjectException;
import java.util.Comparator;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Arrays;

/**
 * One object of this class represents one contact to be added to the list. Each field takes its own object
 * and may have specialized methods.
 */
public class Contact implements IContact, Serializable, Comparable
{
    private FirstName first;
    private LastName last;
    private EmailAddress email;
    private StreetAddress streetAddr;
    private PhoneNumber phone;
    private ContactNotes notes;

    /**
     * Default constructor for Contact.
     */
    public Contact()
    {

    }

    /**
     * @param first:      expects FirstName object representing the first name of the contact
     * @param last:       expect LastName object representing the last name of the contact
     * @param email:      expects EmailAddress object representing the email address of the contact
     * @param streetAddr: expects EmailAddress object representing the email address of the contact
     * @param phone:      expects PhoneNumber object representing the phone number of the contact
     * @param notes:      expects ContactNotes object representing notes for the contact
     */
    public Contact(FirstName first,
                   LastName last,
                   EmailAddress email,
                   StreetAddress streetAddr,
                   PhoneNumber phone,
                   ContactNotes notes)
    {
        this.first=first;
        this.last=last;
        this.email=email;
        this.streetAddr=streetAddr;
        this.phone=phone;
        this.notes=notes;
    }
    /**
     * Calls the checkHasValidString method on each of the parameters of the object, return false if the check fails.
     */
    public boolean checkParametersAreValid()
    {
        // Checking to make sure all passed fields are valid. The methods are defined in their own classes
        if (!last.checkHasValidString())
        {
            return false;
        }
        if(!first.checkHasValidString())
        {
            return false;
        }
        if (!email.checkHasValidString())
        {
            return false;
        }
        if (!streetAddr.checkHasValidString())
        {
            return false;
        }
        if (!phone.checkHasValidString())
        {
            return false;
        }
        if (!notes.checkHasValidString())
        {
            return false;
        }
        return true;
    }

    /**
     *
     * @return: Will return object of FirstName class, for given object
     */
    public FirstName getFirst()
    {
        return first;
    }

    /**
     *
     * @param: First expects object of FirstName class
     */
    public void setFirst(FirstName first)
    {
        this.first = first;
    }

    /**
     *
     * @return: Will return object of LastName class, for given object
     */
    public LastName getLast()
    {
        return last;
    }

    /**
     *
     * @param last: expects object of LastName class
     */
    public void setLast(LastName last)
    {
        this.last = last;
    }

    /**
     *
     * @return: will return object of EmailAddress class, for given object
     */
    public EmailAddress getEmail()
    {
        return email;
    }

    /**
     *
     * @param email: expects object of EmaillAddress class
     */
    public void setEmail(EmailAddress email)
    {
        this.email = email;
    }

    /**
     *
     * @return: will return object of StreetAddress class, for given object
     */
    public StreetAddress getStreetAddr()
    {
        return streetAddr;
    }

    /**
     *
     * @param streetAddr: expects object of StreetAddress class
     */
    public void setStreetAddr(StreetAddress streetAddr)
    {
        this.streetAddr = streetAddr;
    }

    /**
     *
     * @return: will return object of PhoneNumber class, for given object.
     */
    public PhoneNumber getPhone()
    {
        return phone;
    }

    /**
     *
     * @param phone: expects object of PhoneNumber class
     */
    public void setPhone(PhoneNumber phone)
    {
        this.phone = phone;
    }

    /**
     *
     * @return: will return object of ContactNotes class, for given object.
     */
    public ContactNotes getNotes()
    {
        return notes;
    }

    /**
     *
     * @param notes: expects object of ContactNotes class
     */
    public void setNotes(ContactNotes notes)
    {
        this.notes = notes;
    }
    @Override
    /**
     * checks
     */
    public int compareTo(Object o)
    {
        try  {
            Contact c2 = (Contact) o;
            int retval = this.getLast().toString().toUpperCase().compareTo(c2.getLast().toString().toUpperCase());
            if (retval != 0) {
                return retval;
            }
            else {
                return this.getFirst().toString().compareTo(c2.getFirst().toString());
            }
        }catch (ClassCastException i){}
        return 0;
    }
}