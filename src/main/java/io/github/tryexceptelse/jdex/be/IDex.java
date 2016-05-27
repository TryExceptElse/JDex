package io.github.tryexceptelse.jdex.be;

import java.util.ArrayList;

/**
 * Java Rolodex interface
 */
public interface IDex {

    ArrayList getList();

    IContact addContact();

    ArrayList search(String first, String last, String email, String streetAddr, String phone);

    void save(String address);

    void load(String address);
}
