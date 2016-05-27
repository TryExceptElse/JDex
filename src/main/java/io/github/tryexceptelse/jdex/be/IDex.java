package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.Contact;

import java.util.ArrayList;

/**
 * Java Rolodex interface
 */
public interface IDex
{
    //will return all objects containted in ArrayList
    ArrayList getList();

    //will return Contact after adding it to list
    Contact addContact();

    //returns list containg contacts that meet requirements
    ArrayList search(String first, String last, String email, String streetAddr, String phone);

    //will serialize ArrayList
    void save(String address);

    //will load Serialization somehow
    void load(String address);
}
