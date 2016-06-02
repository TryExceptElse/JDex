package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.Contact;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * One object of this class will be an ArrayList containing contact objects.
 * This class will build an ArrayList which will store the Contacts created by using the Contact class. It will
 * implement the methods called by class IDex.
 * This class was written by Marcus Edholm
 */
public class Rolodex implements IDex
{
    /**
     * this will store all of the Contact objects and will have methods to be able to access them.
     */
    private ArrayList arrayList = new ArrayList();

    /**
     *getList will  all objects containted in arrayList.
     */
    public ArrayList getList()
    {
        return arrayList;
    }
    /**
     * will return Contact after adding it to arrayList. This lets lets us modify the contact that was just
     * added without having to search for it.
     */
    public Contact addContact(HashMap<String, String> entries)
    {
        return null;
    }
    /**
     *returns an ArrayList containg the contacts that meet requirements.
     */
    public ArrayList search(HashMap<String, String> entries)
    {
        return null;
    }
    /**
     * will serialize ArrayList.
     */
    public void save(String address)
    {

    }
    /**
     * will load Serialization.
     */
    public void load(String address)
    {

    }
}
