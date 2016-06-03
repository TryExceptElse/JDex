package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import javafx.scene.control.*;

import java.util.HashMap;

/**
 * Handles user interaction with search button and related elements.
 */
public class SearchHandler extends Handler{
    private ToolBar toolBar; // containing toolbar. not actually owned by SearchHandler
    private Button searchButton; // search button. controlled, but not owned by SearchHandler
    // (it shouldn't be removed when SearchHandler closes)

    // owned elements:
    private Label searchLabel; // label for the search field. "SearchHandler Contacts:" or similar
    private TextField searchField; // field for the user to enter last name to be searched for
    private Button goButton; // button to confirm the user's entry,
    private Button closeButton; // button to close the search field

    /**
     * Constructor for search handler
     * @param controller: Main Controller which initiates this handler.
     */
    public SearchHandler(MainCont controller){
        super(controller);
    }

    /**
     * Method called when the user clicks on the search button.
     * Should create new field, label, and buttons for searching and
     * closing the search mode.
     */
    public void searchButtonPress(){
        // placeholder
    }

    /**
     * Method called when a search is confirmed by clicking the go button.
     * Creates search label, field, and buttons, for user's use.
     */
    private void goButtonPress(){
        // placeholder
    }

    /**
     * Method called when search mode is closed by clicking close button
     * closes and removes search's visual elements
     */
    private void closeButtonPress(){
        // placeholder
    }

    /**
     * cleans search's visual elements from application window
     */
    private void cleanUp(){
        // placeholder
    }
}
