package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.*;

/**
 * Contact Interface. These methods will be called by frontend elements,
 * and so need to be accessible and react predictably
 */
public interface IContact
{
    public FirstName getFirst();
    public void setFirst(FirstName first);
    public LastName getLast();
    public void setLast(LastName last);
    public EmailAddress getEmail();
    public void setEmail(EmailAddress email);
    public StreetAddress getStreetAddr();
    public void setStreetAddr(StreetAddress streetAddr);
    public PhoneNumber getPhone();
    public void setPhone(PhoneNumber phone);
    public ContactNotes getNotes();
    public void setNotes(ContactNotes notes);
    public boolean checkParametersAreValid(Contact contact);

}