package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.entries.LastName;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;

import static io.github.tryexceptelse.jdex.fe.gui.GuiUtil.icon;
import static io.github.tryexceptelse.jdex.fe.gui.GuiUtil.iconImage;

import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        // if there are no contacts to search, tell the user.
        if (jDex.getRolodex().getContacts().size() == 0){
            showNoContactsDialogue();
            return;
        }
        toolBar = controller.toolBar;
        searchButton = controller.searchButton;

        //make search button invisible while searching
        searchButton.setVisible(false);
        // make search label
        searchLabel = new Label("Search Last Names:");
        // make search Field
        searchField = new TextField();
        searchField.setPromptText("Last Name");
        searchField.setTooltip(new Tooltip(
                "Last Name to search for in contacts"));
        // make buttons
        goButton = new Button("Find", icon("search.png"));
        goButton.setOnAction((event) -> goButtonPress());
        goButton.setTooltip(new Tooltip("Find Matches"));
        closeButton = new Button("Close", icon("cancel.png"));
        closeButton.setOnAction((event) -> closeButtonPress());
        closeButton.setTooltip(new Tooltip("Close search bar"));
        // add to toolbar
        toolBar.getItems().add(searchLabel);
        toolBar.getItems().add(searchField);
        toolBar.getItems().add(goButton);
        toolBar.getItems().add(closeButton);
    }

    /**
     * Method called when a search is confirmed by clicking the go button.
     * Creates search label, field, and buttons, for user's use.
     */
    private void goButtonPress(){
        LastName lastNameToFind = new LastName(searchField.getText());
        ArrayList<Contact> results = jDex.getRolodex().search(lastNameToFind);
        if (results.size() > 0){
            controller.setTableContents(results);
            app.setMessage("Displaying contacts with last name: " +
                    lastNameToFind.getEntryString());
        } else {
            app.setMessage(String.format("No results found for \'%s\'",
                    lastNameToFind));
            showNoResultsDialogue(lastNameToFind.toString());
        }

    }

    /**
     * Method called when search mode is closed by clicking close button
     * closes and removes search's visual elements
     */
    private void closeButtonPress(){
        controller.setTableContents(jDex.getRolodex().getContacts());
        cleanUp();
    }

    /**
     * cleans search's visual elements from application window
     */
    private void cleanUp(){
        toolBar.getItems().removeAll(searchLabel, searchField, goButton, closeButton);
        searchLabel = null;
        searchField = null;
        goButton = null;
        closeButton = null;
        searchButton.setVisible(true);
    }

    /**
     * shows dialogue to user informing them that there are no contacts to
     * be searched.
     */
    private void showNoContactsDialogue(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("No Contacts");
        Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(iconImage("search.png"));
        alert.setHeaderText(null);
        alert.setContentText("There are no contacts to search.");
        alert.showAndWait();
    }

    /**
     * shows dialogue to user informing them that no contacts were found
     */
    private void showNoResultsDialogue(String searchString){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("No Contacts Found");
        Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(iconImage("search.png"));
        alert.setHeaderText(null);
        alert.setContentText("No contacts with last name: " + searchString);
        alert.showAndWait();
    }
}
