package io.github.tryexceptelse.jdex.be;

/**
 * Contact Interface. These methods will be called by frontend elements,
 * and so need to be accessible and react predictably
 */
interface IContact
{
    public void setKey(String key, String value);
    public String getEntry(String key);
}
