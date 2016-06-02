package io.github.tryexceptelse.jdex.fe.gui;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Gui controller for main program window
 */
public class MainCont implements Initializable {

    /**
     * Method called by FXMLLoader when initialization is completed
     * @param fxmlFileLocation: Location of fxml file
     * @param resources: Resource bundle
     */
    @Override //
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // this is called after all @FXML variables
    }

    /**
     * creates new empty rolodex of contacts
     */
    public void newDex(){} // skeleton

    /**
     * saves current dex to the location it was loaded from,
     * or calls saveAs if it is a new dex or has no location
     */
    public void save(){} //skeleton

    /**
     * Opens save-as dialogue, then instructs Rolodex to save to location inputted
     * user
     */
    public void saveAs(){} //skeleton

    /**
     * Opens load dialogue, then loads the Rolodex from the location inputted
     */
    public void load(){} //skeleton
}
