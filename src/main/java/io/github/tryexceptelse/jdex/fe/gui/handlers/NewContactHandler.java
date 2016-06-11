package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.be.IContact;
import io.github.tryexceptelse.jdex.be.entries.*;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.InvalidObjectException;
import java.lang.reflect.Method;

/**
 * Handles user interaction with new contact button, and resulting fields.
 */
public class NewContactHandler extends Handler{
    // array of entry classes, in order used
    private final Class[] entryClasses = new Class[]{
                FirstName.class,
                LastName.class,
                EmailAddress.class,
                StreetAddress.class,
                PhoneNumber.class,
                ContactNotes.class,
    };
    // array of prompt strings, in order used
    private final String[] promptStrings = new String[]{
                "Enter First Name",
                "Enter Last Name",
                "Enter Email Address",
                "Enter Street Address",
                "Enter Phone Number",
                "Notes"
    };
    private final String[] labelStrings = new String[]{
            "First Name:",
            "Last Name:",
            "Email Address:",
            "Street Address:",
            "Phone Number:",
            "Notes:"
    };
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
        Label[] labels = createLabels();
        TextField[] fields = createFields();
        Button cancelButton = makeCancelButton();
        Button createButton = makeCreateButton(fields);
        GridPane grid = createNewContactGrid(
                labels, fields, createButton, cancelButton);
        createPopUpStage(grid);
    }

    /**
     * Creates label objects to be displayed to user, explaining the purpose of
     * @return Label[] Labels array
     * 
     * Helper-method for newContactButtonPress.
     */
    private Label[] createLabels(){
        Label[] labels = new Label[labelStrings.length];
        for (int i = 0; i < labels.length; i++) labels[i] =
                new Label(labelStrings[i]);
        return labels;
    }

    /**
     * Creates text fields for the user to enter data within.
     * The data that the user enters in these fields is used to create the
     * new Contact Object
     *
     * Helper-method for newContactButtonPress.
     * 
     * @return TextFields[] Array of TextFields for entering data to be used
     * for new Contact
     */
    private TextField[] createFields(){
        TextField[] fields = new TextField[6];
        String[] prompts;
        // create fields
        for (int i = 0; i < fields.length; i++){
            fields[i] = new TextField();
        }
        // create prompts
        prompts = promptStrings;
        // list entry classes in order used
        Class[] entryClasses = this.entryClasses;
        // assign prompts to fields
        for (int i = 0; i < prompts.length; i++){
            TextField field = fields[i];
            Class entryClass = entryClasses[i];
            field.setPromptText(prompts[i]);
            field.textProperty().addListener(
                    (observable, oldValue, newValue) ->
                            checkFieldEntry(field, entryClass)
            );
        }
        return fields;
    }
    /**
     * Returns array of  entry classes in order used
     *
     * Helper method for createFields
     * @return Class[] of entry Classes
     */
    private static Class[] getEntryClasses(){
        return new Class[]{
                FirstName.class,
                LastName.class,
                EmailAddress.class,
                StreetAddress.class,
                PhoneNumber.class,
                ContactNotes.class,
        };
    }

    /**
     * Creates 'Create' button which when pressed creates and adds a contact
     * containing entered information.
     *
     * This method returns a Button object which when clicked, calls the
     * create(TextField[]) method of this object.
     *
     * Helper-method for newContactButtonPress.
     * @param dataEntryFields: TextFields[] in which the user will enter
     *                       information for the new Contact.
     * @return 'create' Button object.
     */
    private Button makeCreateButton(TextField[] dataEntryFields){
        Button createButton = new Button("Create");
        createButton.setTooltip(new Tooltip(
                "Create new contact and add it to the rolodex"));
        createButton.setOnAction(event -> create(dataEntryFields));
        return createButton;
    }

    /**
     * Creates 'Cancel' Button object.
     * This Button, when clicked by user, calls the cancel() method of
     * this object.
     *
     * Helper-method for newContactButtonPress.
     * @return 'Cancel' Button object.
     */
    private Button makeCancelButton(){
        Button cancelButton = new Button("Cancel");
        cancelButton.setTooltip(new Tooltip("Cancel creating new contact"));
        cancelButton.setOnAction(event -> cancel());
        return cancelButton;
    }

    /**
     * Creates pop-up stage (window) in which the passed grid of GUI objects
     * is displayed
     * 
     * The created window always appears over the main Application window, and
     * locks out actions in that window until either a new contact has been
     * created, or Contact creation has been cancelled.
     *
     * Helper-method for newContactButtonPress.
     * @param newContactGrid: Grid object containing GUI elements for Contact
     *                      creation.
     * @return Pop-up Stage
     */
    private Stage createPopUpStage(GridPane newContactGrid){
        popUpStage = new Stage();
        popUpStage.initModality(Modality.APPLICATION_MODAL); // locks out main
            // ..window until this one has been closed.
        popUpStage.initOwner(app.getStage()); // sets this stage's owner.
        Scene newContactScene = new Scene(newContactGrid);
        popUpStage.setScene(newContactScene);
        popUpStage.setAlwaysOnTop(true);
        popUpStage.show();
        return popUpStage;
    }

    /**
     * Creates the grid of labels, entry fields, and buttons which makes up the
     * 'New Contact' Pop-up dialogue with the user.
     *
     * Helper-method for newContactButtonPress.
     * 
     * @param labels: Label[] containing labels for the new contact's data 
     *              entry fields
     * @param fields: TextField[] in which the user enters data for the new
     *              Contact.
     * @param createButton: Button which is to be placed at the lower-right, to
     *                    confirm creation of the Contact.
     * @param cancelButton: Button placed on lower-left, to cancel Contact
     *                    creation.
     * @return Grid of GUI elements assembled appropriately for contact 
     * creation
     */
    private GridPane createNewContactGrid(Label[] labels,
                                          TextField[] fields,
                                          Button createButton,
                                          Button cancelButton){
        // set up grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(32., 32., 32., 32.)); // margins
        grid.setVgap(8.); // distance between contained elements.
        grid.setHgap(8.);

        // set positions of contained elements
        assert labels.length == fields.length; // for loop expects equal..
            // ..lengths of arrays (one label for each field)
        for (int i = 0; i < labels.length; i++){
            GridPane.setConstraints(labels[i], 0, i); // set label positions
            GridPane.setConstraints(fields[i], 1, i); // set field positions
        }
        // set button positions. Create at lower-right, Cancel at lower-left.
        GridPane.setConstraints(createButton, 1, fields.length + 1);
        GridPane.setConstraints(cancelButton, 0, labels.length + 1);

        // add objects to grid
        for (int i = 0; i < labels.length; i++){
            grid.getChildren().add(labels[i]);
            grid.getChildren().add(fields[i]);
        }
        grid.getChildren().addAll(createButton, cancelButton);
        return grid;
    }
    /**
     * Checks data entered by user in the field.
     * If the entered String has problems, or should result in feedback,
     * applies visual effects and sets tool-tip.
     *
     * Nothing is done with the entered String, passing it to the new Contact
     * is handled by the create(TextField[]) method.
     *
     * @param field: TextField which contains string to check, and to which
     *             visual effects and tool-tips should be applied.
     * @param contactEntryClass: class to check with to determine whether
     *                         string is valid, and what message if any should
     *                         be displayed.
     */
    private void checkFieldEntry(TextField field, Class contactEntryClass) {
        // assert contactEntryClass inherits from ContactEntry
        assert ContactEntry.class.isAssignableFrom(contactEntryClass);
        String entryString = field.getText();
        // get feedback string to be displayed as tool-tip
        String entryFeedback = getEntryFeedback(contactEntryClass, entryString);
        // get bool of whether user's entry is valid
        boolean entryIsValid = checkStringIsValid(contactEntryClass, entryString);
        // apply effects.
        if (entryIsValid) field.setStyle("-fx-control-inner-background: white;");
        else field.setStyle("-fx-control-inner-background: red;");
        // set tooltip to be displayed on mouse-hover
        field.setTooltip(new Tooltip(entryFeedback));
    }

    /**
     * Gets feedback to a string entered by a user.
     * Helper method to checkFieldEntry.
     * @param entryClass: Class to check string with.
     * @param entryString: String entered by user which is to be checked.
     * @return String of feedback to user's entry.
     */
    private String getEntryFeedback(Class entryClass,String entryString){
        Method getStringFeedbackMethod; // method to return string feedback
        String entryFeedback;
        // assert entryClass inherits from ContactEntry
        assert ContactEntry.class.isAssignableFrom(entryClass);
        try {
            getStringFeedbackMethod = entryClass.getMethod(
                    "getStringFeedback", String.class); //name, argument type
            entryFeedback = (String)getStringFeedbackMethod.invoke(null, entryString);
        } catch (Exception e){
            e.printStackTrace();
            entryFeedback = "";
        }
        return entryFeedback;
    }

    /**
     * Checks whether an entered string is valid
     * Helper method to checkFieldEntry
     * @param entryClass: Class against which string will be checked for
     *                  validity.
     * @param entryString: String entered by user.
     * @return boolean of whether entryString is valid.
     */
    private boolean checkStringIsValid(Class entryClass, String entryString){
        Method checkValidityMethod;
        boolean returnBool;
        // Assert entryClass inherits from ContactEntry
        assert ContactEntry.class.isAssignableFrom(entryClass);
        try{
            checkValidityMethod = entryClass.getMethod(
                    "checkStringIsValid", String.class); // name, arg type
            returnBool = (boolean)checkValidityMethod.invoke(null, entryString);
        } catch (Exception e){
            e.printStackTrace();
            returnBool = true;  // better just to let the program get on.
        }
        return returnBool;
    }


    /**
     * Method called when user clicks the cancel button in the Contact creation
     * pane.
     * Ends dialogue with user, returns User interface to state it was in
     * before they clicked "New Contact"
     */
    private void cancel(){
        app.setMessage("cancelled creating new contact");
        cleanUp();
    }

    /**
     * Method called by the 'Create' button when the user clicks on it in the
     * Contact creation pane.
     * @param fields: Data entry fields which the user has been prompted to
     *              enter data in.
     */
    private void create(TextField[] fields){
        // skeleton placeholder.
        // Should get the information entered in fields and call rolodex to
        // add a new Contact, using the gathered information.
        try {
            // make entry objects
            FirstName first = new FirstName(fields[0].getText());
            LastName last = new LastName(fields[1].getText());
            EmailAddress email = new EmailAddress(fields[2].getText());
            StreetAddress streetAddr = new StreetAddress(fields[3].getText());
            PhoneNumber phone = new PhoneNumber(fields[4].getText());
            ContactNotes notes = new ContactNotes(fields[5].getText());
            // create Contact
            IContact newContact = jDex.getRolodex().
                    addContact(first, last, email, streetAddr, phone, notes);
            app.setMessage(String.format("created new contact for %s, %s",
                    newContact.getLast().getEntryString(), newContact.getFirst()
                            .getEntryString()));
            controller.refreshTable();
            cleanUp();
        } catch (InvalidObjectException e){
            app.setMessage("could not add contact; invalid entered data");
            // assert there should be one entry class for each field.
            assert fields.length == getEntryClasses().length;
            for (int i = 0; i < fields.length; i++){
                TextField field = fields[i];
                Class entryClass = entryClasses[i];
                checkFieldEntry(field, entryClass);
            }
        }
    }

    /**
     * method called once user has either finished creating a new contact,
     * or has cancelled out.
     * Cleans the GUI of any elements created by this handler for getting
     * information, or other reasons.
     */
    private void cleanUp(){
        popUpStage.close();
        popUpStage = null;
    }

}
