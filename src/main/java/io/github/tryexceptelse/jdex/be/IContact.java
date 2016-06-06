package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.ContactEntry;

/**
 * Contact Interface. These methods will be called by frontend elements,
 * and so need to be accessible and react predictably
 */
public interface IContact {
    /**
     * Contacts should be able to store a ContactEntry object
     * as an entry with a given key.
     * @param key: String key to store entry with.
     * @param entry: ContactEntry object to be stored.
     */
    void setEntry(String key, ContactEntry entry);

    /**
     * Contacts should be able to get a stored entry using a passed key
     * @param key: String key to be used to retrieve entry.
     * @return ContactEntry object stored with key.
     */
    ContactEntry getEntry(String key);
}
