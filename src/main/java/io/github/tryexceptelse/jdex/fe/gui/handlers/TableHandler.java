package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.IRolodex;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * TableHandler Handler for GUI; Creates and operates the main Contacts table.
 */
public class TableHandler extends Handler{
    private TableView table;
    private ArrayList<Contact> tableContents;

    public TableHandler(MainCont controller){
        super(controller);
        table = controller.contactsTable;
    }

    /**
     * Initializes table and assigns starting values
     */
    public void initializeTable() {
        IRolodex rolodex = jDex.getRolodex();
        ArrayList<Contact> contacts = rolodex.getContacts();
        setTableContents(contacts);

        // set column value factories
        controller.firstColumn.setCellValueFactory(valueFactory("getFirst"));
        controller.lastColumn.setCellValueFactory(valueFactory("getLast"));
        controller.emailColumn.setCellValueFactory(valueFactory("getEmail"));
        controller.streetAddrColumn.setCellValueFactory(valueFactory("getStreetAddr"));
        controller.phoneColumn.setCellValueFactory(valueFactory("getPhone"));
        controller.notesColumn.setCellValueFactory(valueFactory("getNotes"));
        // note: need to fix these unchecked calls.
    }

    /**
     * Creates a value factory that returns the values contained in the
     * observable list's contacts with the passed String key.
     * @param getterName: String name of Contact's getter which when called,
     *                  returns the String that is to be displayed
     * @return Callback object that on call, will retrieve data from contact,
     * using passed entryName String.
     */
    private Callback<TableColumn.CellDataFeatures<Contact, String>,
            ObservableValue<String>>
    valueFactory(String getterName){
        // define returned method.
        return p -> {
            // set default values
            Method getterMethod = null;
            ObservableValue<String> tableCellValue = new ReadOnlyObjectWrapper<>("");
            // try to get the method named by passed arg String
            try{
                getterMethod = p.getValue().getClass().getMethod(getterName);
            } catch (NoSuchMethodException e){
                e.printStackTrace();
            } finally {
                // if retrieved method is not null
                if (getterMethod != null) {
                    // try to get the value it returns, and create an
                    // ObservableValue with it to be returned.
                    try {
                        tableCellValue = new ReadOnlyObjectWrapper<>(
                                getterMethod.invoke(p.getValue()).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return tableCellValue;
        };
    }

    /**
     * Refresh table, instructs table to display any new values in contacts,
     * remove deleted ones, or adjust edited ones.
     */
    public void refresh(){
    table.setItems(FXCollections.observableArrayList(tableContents));
}

    /**
     * Sets table contents to list of contacts.
     * @param contacts: New contacts list to be displayed
     */
    public void setTableContents(ArrayList<Contact> contacts){
        table.setItems(FXCollections.observableArrayList(contacts));
        tableContents = contacts;
    }

    /**
     * Gets table contents
     * @return ArrayList of Contacts
     */
    public ArrayList<Contact> getTableContents(){
        return tableContents;
    }
}
