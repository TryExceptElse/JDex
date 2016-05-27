package io.github.tryexceptelse.jdex.be;

/**
 * Contact Interface. These methods will be called by frontend elements,
 * and so need to be accessible and react predictably
 */
interface IContact {
    void setFirst(String newFirst);
    void setLast(String newLast);
    void setEmail(String newEmail);
    void setStreetAddr(String newStreetAddr);
    void setPhoneNumber(String newPhoneNumber);
    void setNotes(String newNotes);

    String getFirst();
    String getLast();
    String getEmail();
    String getstreetAddr();
    String getPhoneNumber();
    String getnotes();
}
