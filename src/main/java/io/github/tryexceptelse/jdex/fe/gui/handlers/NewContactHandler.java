package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * Handles user interaction with new contact button, and resulting fields.
 */
public class NewContactHandler extends Handler{
    private Stage popUpStage; // popup window stage. may be null if not active.

    /**
     * Constructor method for NewContactHandler.
     * @param controller: reference to MainCont object which owns this object.
     */
    public NewContactHandler(MainCont controller){
        super(controller);
    }

    /**
     * Method called upon the user clicking the "New Contact" button.
     * creates pop-up window requesting information to be passed to the new
     * contact.
     */
    public void newContactButtonPress(){
        // skeleton placeholder.
        // Should create interface for adding new contacts to the Rolodex.
    }

    /**
     * Method called when user clicks the cancel button in the Contact creation
     * pane.
     * Ends dialogue with user, returns User interface to state it was in
     * before they clicked "New Contact"
     */
    private void cancel(){
        // skeleton placeholder
    }

    /**
     * Method called when the user clicks the "create" button in the Contact
     * creation pane.
     * @param fields: Data entry fields which the user has been prompted to
     *              enter data in.
     */
    private void create(TextField[] fields){
        // skeleton placeholder.
        // Should get the information entered in fields and call rolodex to
        // add a new Contact, using the gathered information.
    }

    /**
     * method called once user has either finished creating a new contact,
     * or has cancelled out.
     * Cleans the GUI of any elements created by this handler for getting
     * information, or other reasons.
     */
    private void cleanUp(){
        // skeleton placeholder.
    }

}
