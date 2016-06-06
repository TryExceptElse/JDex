package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.IRolodex;
import io.github.tryexceptelse.jdex.be.Rolodex;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.util.ArrayList;

/**
 * TableHandler Handler for GUI; Creates and operates the main Contacts table.
 */
public class TableHandler extends Handler{
    private TableView table;
    private ArrayList<Contact> tableContents;

    public TableHandler(MainCont controller){
        // skeleton placeholder
    }

    /**
     * Initializes table and assigns starting values
     */
    public void initializeTable() {
        // skeleton placeholder
    }

    /**
     * Creates a value factory that returns the values contained in the
     * observable list's contacts with the passed String key.
     * @param entryName: String of entry key to be found by factory
     *                 in passed objects
     * @return Callback object that on call, will retrieve data from contact,
     * using passed entryName String.
     */
    private Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>>
            valueFactory(String entryName){
        // skeleton placeholder.
        return call -> null;
    }

    /**
     * Refresh table, instructs table to display any new values in contacts,
     * remove deleted ones, or adjust edited ones.
     */
    public void refresh(){
        // skeleton placeholder
    }

    /**
     * Sets table contents to list of contacts.
     * @param contacts: New contacts list to be displayed
     */
    public void setTableContents(ArrayList<Contact> contacts){
        // skeleton placeholder
    }

    /**
     * Gets table contents
     * @return ArrayList of Contacts
     */
    public ArrayList<Contact> getTableContents(){
        return tableContents;
    }
}
