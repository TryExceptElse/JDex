package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.IRolodex;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.awt.Desktop;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

/**
 * TableHandler Handler for GUI; Creates and operates the main Contacts table.
 */
public class TableHandler extends Handler{
    private TableView<Contact> table;
    private ArrayList<Contact> tableContents;

    private final ArrayList<TableColumn<Contact, String>> columns =
            new ArrayList<TableColumn<Contact, String>>(){{
                add(controller.firstColumn);
                add(controller.lastColumn);
                add(controller.emailColumn);
                add(controller.streetAddrColumn);
                add(controller.phoneColumn);
                add(controller.notesColumn);
            }};

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
        // set cell factories for columns
        setCellFactories();
    }

    /**
     * Sets cell factories for column
     * For each cell, sets right mouse click event to call dropDownMenu.
     */
    private void setCellFactories(){
        for (TableColumn<Contact, String> column : columns)
            column.setCellFactory(p -> {
                TableCell<Contact, String> cell = new TableCell<>();
                cell.textProperty().bind(cell.itemProperty());
                cell.setContextMenu(cellDropDownMenu(cell));
                return cell;
            });
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
            ObservableValue<String> tableCellValue =
                    new ReadOnlyObjectWrapper<>("");
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
     * Creates, populates and formats a right click drop-down
     * menu for the user.
     * Called when the user right clicks on a cell.
     * @param cell: TableCell which has been right-clicked by the user.
     */
    private ContextMenu cellDropDownMenu(TableCell<Contact, String> cell){
        // create 'Add Contact' menu item
        MenuItem addItem = new MenuItem("Add Contact");
        addItem.setOnAction(event -> controller.newContact());
        // create 'Create New Email' menu item
        MenuItem sendEmail = new MenuItem("Create New Email");
        sendEmail.setOnAction(event ->
                openEmailClientWithContact(cellContact(cell)));
        // create 'Find Address' menu item
        MenuItem openInMap = new MenuItem("Open In Map");
        openInMap.setOnAction(event -> openMapWithContact(cellContact(cell)));
        // create 'Delete' menu item
        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(event -> deleteContact(cellContact(cell)));
        // add item(s)
        return new ContextMenu(addItem, sendEmail, openInMap, deleteItem);
    }

    /**
     * Returns contact object from passed TableCell
     * @param cell: TableCell object.
     * @return Contact object used to provide cell information.
     */
    private Contact cellContact(TableCell<Contact, String> cell){
        return (Contact)cell.getTableRow().getItem();
    }

    /**
     * Opens user's default email client with passed contact's email
     * @param contact: Contact to attempt to send email to.
     */
    private void openEmailClientWithContact(Contact contact){
        if (!Desktop.isDesktopSupported()){
            showEmailErrorDialogue("Could not connect to desktop");
        }
        if (contact == null) {
            showEmailErrorDialogue("Empty contact row was selected");
            return;
        }
        if (contact.getEmail().toString().trim().length() == 0) {
            showEmailErrorDialogue("Contact has empty email field");
            return;
        }
        new Thread(() -> {
            try{
                Desktop.getDesktop().mail(URI.create(
                        mailUri(contact.getEmail().toString()))); // open email
            } catch (Exception e){
                e.printStackTrace();
                showEmailErrorDialogue("Error creating new email");
            }
        }).start();
    }

    /**
     * create mail uri
     * @param address emailAddress String to create mail uri from.
     * @return String uri
     */
    private String mailUri(String address){
        return String.format("mailto:%s", address);
    }

    /**
     * Shows email error
     * @param msg: message to be displayed to used in dialogue box.
     */
    private void showEmailErrorDialogue(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Could not create email");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Opens passed Contact's address in google maps
     * @param contact: contact to find the address of.
     */
    private void openMapWithContact(Contact contact){
        if (contact == null) {
            showMapErrorDialogue("Empty contact row was selected");
            return;
        }
        if (!Desktop.isDesktopSupported()){
            showMapErrorDialogue("Could not connect to desktop");
            return;
        }
        if (contact.getStreetAddr().toString().trim().length() == 0) {
            showMapErrorDialogue("Contact has empty email field");
            return;
        }
        new Thread(() -> {
            try {
                Desktop.getDesktop().browse(new URI(uriFromAddress(
                        contact.getStreetAddr().toString())));
            } catch (IllegalStateException e){
                e.printStackTrace();
            } catch (Exception e){
                showMapErrorDialogue("Could not open address in map");
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * get map uri to open, from a passed address string
     */
    private String uriFromAddress(String address){
        address = address.replace(' ', '+');
        return String.format("http://maps.google.com/maps?q=%s",
                address);
    }

    /**
     * Shows info dialogue to user explaining why maps could not be openned
     * @param msg: String to be shown to user within dialogue
     */
    private void showMapErrorDialogue(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Could not open in maps");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Safely tries to delete passed contact from Rolodex.
     * Method called when user selects option to delete selected row.
     * Handles race conditions or nonexistent object errors gracefully.
     * If called on empty row, presents information dialogue informing the user
     * they may not delete empty rows.
     * @param contact: Contact to be removed from rolodex.
     */
    private void deleteContact(Contact contact){
        if (contact == null) showEmptyRowDeletionDialogue();
        else {
            if (showConfirmDeleteDialogue(contact))
                try {
                    jDex.getRolodex().getContacts().remove(contact);
                    refresh();
                    app.setMessage(String.format(
                            "Removed %s, %s from contacts.",
                            contact.getLast(), contact.getFirst()));
                } catch (Exception e) {      // prevent race conditions, etc
                    e.printStackTrace();
                    app.setMessage("Error removing contact from rolodex.");
                }
            else app.setMessage("Cancelled deleting contact.");
        }
    }

    /**
     * Shows 'empty row deletion attempt' info dialogue to user.
     * Helper method to 'deleteContact.'
     */
    private void showEmptyRowDeletionDialogue(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Deleting empty row");
        alert.setHeaderText(null);
        alert.setContentText("Empty rows cannot be deleted.");
        alert.showAndWait();
    }

    /**
     * Shows delete confirmation dialogue.
     * Helper method to 'deleteContact'
     * @param contact: Contact with information (name) to be shown in
     *               dialogue.
     * @return boolean of how user responded
     */
    private boolean showConfirmDeleteDialogue(Contact contact){
        // make confirmation alert
        Alert confirmDialogue = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialogue.setTitle("Delete Contact?");
        confirmDialogue.setHeaderText("Are you sure?");
        confirmDialogue.setContentText(String.format(
                "Remove %s %s from contacts?",
                contact.getFirst(), contact.getLast()));
        // show alert
        Optional<ButtonType> result = confirmDialogue.showAndWait();
        // if user response was to click 'ok' button, return true
        return result.isPresent() && result.get() == ButtonType.OK;
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
