package io.github.tryexceptelse.jdex.fe.gui;

import io.github.tryexceptelse.jdex.JDex;
import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.fe.gui.handlers.MessageBarHandler;
import io.github.tryexceptelse.jdex.fe.gui.handlers.NewContactHandler;
import io.github.tryexceptelse.jdex.fe.gui.handlers.SearchHandler;
import io.github.tryexceptelse.jdex.fe.gui.handlers.TableHandler;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Gui controller for main program window
 * This object controls the gui elements which appear to the user
 * Most of the methods here are those called when the user presses a button or
 * otherwise interacts with the GUI
 * These methods are called directly by Application when the user takes
 * an action.
 */
public class MainCont implements Initializable {

    // GUI Elements
    // these are arranged in roughly top-down order as they appear in the GUI
    // they need to be public in order to be accessed by FXMLLoader
    public ToolBar toolBar;
    public Button newButton;
    public Button searchButton;
    public TableView contactsTable;
    public TableColumn firstColumn;
    public TableColumn lastColumn;
    public TableColumn emailColumn;
    public TableColumn streetAddrColumn;
    public TableColumn phoneColumn;
    public TableColumn notesColumn;
    public Label messageLabel;

    //handlers
    private NewContactHandler newContactHandler;
    private SearchHandler searchHandler;
    private TableHandler table;
    private MessageBarHandler messageBar;

    private JDex activeJDex; // program JDex object
    private AppWindow app; // running application

    /**
     * Method called by FXMLLoader when initialization is completed.
     * @param fxmlFileLocation: Location of fxml file
     * @param resources: Resource bundle
     */
    @Override //
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // this is called after all @FXML variables
    }

    /**
     * creates handler objects that will handle code related to specific
     * elements / functionalities of the GUI.
     */
    void createHandlers(){
        // skeleton placeholder.
        // should initialize all handler variables with their appropriate Class.
    }

    /**
     * Creates dialogue to add new Contact.
     *
     * This method is directly called by Application when the user clicks
     * the New Contact Button.
     */
    public void newContact(){
        // skeleton placeholder
        // should call "newContactButtonPressed" in newContactHandler.
    }

    /**
     * Creates search entry fields
     * and uses values to find list of matching Contacts.
     *
     * This method is directly called by
     */
    public void search(){
        // skeleton placeholder
        // should call "newContactButtonPressed" in searchHandler.
    }

    /**
     * Refreshes table to update displayed contacts.
     * May add, edit, or remove as needed
     */
    public void refreshTable(){
        // placeholder.
    }

    /**
     * Sets message which is to be displayed to user
     * @param msg String of message to be displayed.
     */
    public void setMessage(String msg){
        // placeholder
    }

    /**
     * Sets AppWindow reference
     * @param app: AppWindow running the application
     */
    public void setApp(AppWindow app){
        // placeholder
        // should set both app, and activeJDex.
        // activeJDex will be set based on app.getJDex()
    }

    /**
     * returns AppWindow currently running the controller
     * @return AppWindow
     */
    public AppWindow getApp(){
        return app;
    }

    /**
     * returns an array of the table columns.
     * @return TableColumn[] TableHandler Columns.
     */
    public TableColumn[] getTableColumns(){
        return new TableColumn[]{}; // placeholder
    }

    /**
     * Gets current table contents
     * @return ArrayList of Contacts
     */
    public ArrayList<Contact> getTableContents(){
        return new ArrayList<>();
    }

    /**
     * Sets table contents to list of contacts.
     * @param contacts: New contacts list to be displayed
     */
    public void setTableContents(ArrayList<Contact> contacts){
        // placeholder skeleton.
    }
}
