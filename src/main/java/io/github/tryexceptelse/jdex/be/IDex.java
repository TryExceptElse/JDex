package io.github.tryexceptelse.jdex.be;

import java.util.ArrayList;

/**
 * Java Rolodex interface
 */
public interface IDex
{
    //will return all objects contained in ArrayList
    ArrayList getList();

    //will return Contact after adding it to list
    Contact addContact();

    //returns list containing contacts that meet requirements
    ArrayList search(String first, String last, String email, String streetAddr, String phone);

    //will serialize ArrayList
    void save(String address);

    //will load Serialization somehow
    void load(String address);
}
