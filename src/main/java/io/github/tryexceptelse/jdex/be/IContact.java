package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.*;

/**
 * Contact Interface. These methods will be called by frontend elements,
 * and so need to be accessible and react predictably
 */
public interface IContact
{
    FirstName getFirst();
    void setFirst(FirstName first);
    LastName getLast();
    void setLast(LastName last);
    EmailAddress getEmail();
    void setEmail(EmailAddress email);
    StreetAddress getStreetAddr();
    void setStreetAddr(StreetAddress streetAddr);
    PhoneNumber getPhone();
    void setPhone(PhoneNumber phone);
    ContactNotes getNotes();
    void setNotes(ContactNotes notes);
    boolean checkParametersAreValid();

}