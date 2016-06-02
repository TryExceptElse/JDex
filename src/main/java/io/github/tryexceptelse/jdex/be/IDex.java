package io.github.tryexceptelse.jdex.be;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Java Rolodex interface
 */
public interface IDex
{
    //will return all objects contained in ArrayList
    ArrayList getList();

    //will return Contact after adding it to list
    Contact addContact(HashMap<String, String> entries);

    //returns list containing contacts that meet requirements
    ArrayList search(HashMap<String, String> entries);

    //will serialize ArrayList
    void save(String address);

    //will load Serialization somehow
    void load(String address);
}
