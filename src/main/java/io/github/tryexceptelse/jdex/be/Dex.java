package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.Contact;

import java.util.ArrayList;

/**
 * One object of this class will be an ArrayList containing contact objects.
 * This class will build an ArrayList which will store the Contacts created by using the Contact class. It will
 * implement the methods called by class IDex.
 * This class was written by Marcus Edholm
 */
public class Dex implements IDex
{
    /**
     * this will store all of the Contact objects and will have methods to be able to access them. ME
     */
    ArrayList arrayList = new ArrayList();

    /**
     *getList will  all objects containted in arrayList. Me
     */
    public ArrayList getList()
    {
        return arrayList;
    }
    /**
     *will return Contact after adding it to arrayList. ME
     */
    public Contact addContact()
    {
        return null;
    }
    /**
     *returns an ArrayList containg the contacts that meet requirements. ME
     */
    public ArrayList search(String first, String last, String email, String streetAddr, String phone)
    {
        return null;
    }

    /**
     * will serialize ArrayList. ME
     */
    public void save(String address)
    {

    }
    /**
     * will load Serialization. ME
     */
    public void load(String address) 
    {

    }
}
