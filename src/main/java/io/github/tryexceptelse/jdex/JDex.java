
package io.github.tryexceptelse.jdex;

import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.entries.*;
import io.github.tryexceptelse.jdex.fe.Ui;
import io.github.tryexceptelse.jdex.fe.gui.AppWindow;
import io.github.tryexceptelse.jdex.fe.gui.Gui;
import io.github.tryexceptelse.jdex.be.IRolodex;
import io.github.tryexceptelse.jdex.be.Rolodex;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import io.github.tryexceptelse.jdex.fe.gui.handlers.MessageBarHandler;
import io.github.tryexceptelse.jdex.fe.gui.handlers.NewContactHandler;
import io.github.tryexceptelse.jdex.fe.gui.handlers.SearchHandler;
import io.github.tryexceptelse.jdex.fe.gui.handlers.TableHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main program class. holds settings, Ui, and Contact Rolodex objects,
 * and makes calls to run the user interface each program loop.
 *
 * project notes:
 * SDK version 1.8
 * requires Java 8 or higher to run
 */
public class JDex {

  private String[] runtimeArgs;
  private Ui ui; // User interface object
  private IRolodex rolodex; // should be imported from backend once available
  private final File contactsFile = buildContactsFile();

  /**
   * Constructor for JDex main class.
   * Builds JDex object and gets it ready to be run by main loop
   */
  public JDex(String[] runtimeArgs) {
    this.runtimeArgs = runtimeArgs;
    rolodex = buildRolodex();
    ui = buildUi();
  }

  /**
   * Constructs a JDex main object and calls it in the main loop
   *
   * @param args: Runtime args
   */
  public static void main(String[] args) {
      //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
      // CONSTRUCTORS
      //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
      //
      // Main object:
      //
      JDex JDexTest = new JDex(args);
      //
      // Backend Objects:
      //
      Contact contactTest = new Contact();
      Rolodex rolodexTest = new Rolodex();
      //
      // ContactEntries:
      //
      ContactEntry contactNotesTest = new ContactNotes();
      ContactEntry emailAddressTest = new EmailAddress();
      ContactEntry firstNameTest = new FirstName();
      ContactEntry lastNameTest = new LastName();
      ContactEntry phoneNumberTest = new PhoneNumber();
      ContactEntry streetAddressTest = new StreetAddress();
      //
      // Frontend Objects:
      //
      AppWindow appWindowTest = new AppWindow();
      Gui guiTest = new Gui(JDexTest);
      MainCont mainContTest = new MainCont();
      //
      // User interface action handlers
      //
      MessageBarHandler messageBarHandlerTest = new MessageBarHandler(mainContTest);
      NewContactHandler newContactHandlerTest = new NewContactHandler(mainContTest);
      SearchHandler searchHandlerTest = new SearchHandler(mainContTest);
      TableHandler tableHandlerTest = new TableHandler(mainContTest);
      
      //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
      // METHODS
      //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

      //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
      // JDex Methods
      JDexTest.setUi(guiTest);
      JDexTest.getUi();
      JDexTest.setRolodex(rolodexTest);
      JDexTest.getRolodex();
      JDexTest.getRuntimeArgs();
      JDexTest.buildUi();
      JDexTest.buildContactsFile();
      JDexTest.buildRolodex();

      // Contact Methods
      contactTest.setEntry("testKey", contactNotesTest);
      contactTest.getEntry("testKey");

      // Rolodex Methods
      rolodexTest.saveContacts();
      rolodexTest.loadContacts();
      rolodexTest.setContacts(new ArrayList<>());
      rolodexTest.getContacts();
      rolodexTest.search(new HashMap<>());

      // ContactNotes methods
      contactNotesTest.checkStringIsValid("String");
      contactNotesTest.getEntryString();
      contactNotesTest.equals(emailAddressTest);
      contactNotesTest.checkHasValidString();
      contactNotesTest.toString();
      contactNotesTest.setEntryString("string");
      contactNotesTest.getEntryString();

      // EmailAddress methods
      emailAddressTest.checkStringIsValid("String");
      emailAddressTest.getEntryString();
      emailAddressTest.equals(emailAddressTest);
      emailAddressTest.checkHasValidString();
      emailAddressTest.toString();
      emailAddressTest.setEntryString("string");
      emailAddressTest.getEntryString();

      // FirstName methods
      firstNameTest.checkStringIsValid("String");
      firstNameTest.getEntryString();
      firstNameTest.equals(emailAddressTest);
      firstNameTest.checkHasValidString();
      firstNameTest.toString();
      firstNameTest.setEntryString("string");
      firstNameTest.getEntryString();

      // LastName methods
      lastNameTest.checkStringIsValid("String");
      lastNameTest.getEntryString();
      lastNameTest.equals(emailAddressTest);
      lastNameTest.checkHasValidString();
      lastNameTest.toString();
      lastNameTest.setEntryString("string");
      lastNameTest.getEntryString();

      // PhoneNumber methods
      phoneNumberTest.checkStringIsValid("String");
      phoneNumberTest.getEntryString();
      phoneNumberTest.equals(emailAddressTest);
      phoneNumberTest.checkHasValidString();
      phoneNumberTest.toString();
      phoneNumberTest.setEntryString("string");
      phoneNumberTest.getEntryString();

      // StreetAddress methods
      streetAddressTest.checkStringIsValid("String");
      streetAddressTest.getEntryString();
      streetAddressTest.equals(emailAddressTest);
      streetAddressTest.checkHasValidString();
      streetAddressTest.toString();
      streetAddressTest.setEntryString("string");
      streetAddressTest.getEntryString();

      // AppWindow methods
      // AppWindow.start() is inherited from Application in Javafx and
      // requires perameters currently unavailable to be passed
      appWindowTest.setMessage("message");
      appWindowTest.getJDex();
      appWindowTest.getStage();
      appWindowTest.getController();

      // Gui methods
      guiTest.run(new String[]{});

      // MainCont methods
      // MainCont.initialize() is is passed arguments from Javafx's Application
      // which require a running application window.
      mainContTest.refreshTable();
      mainContTest.newContact();
      mainContTest.search();
      mainContTest.getTableColumns();
      mainContTest.setApp(appWindowTest);
      mainContTest.getApp();
      mainContTest.setTableContents(new ArrayList<>());
      mainContTest.getTableContents();
      mainContTest.setMessage("string");

      // MessageBarHandler methods
      messageBarHandlerTest.setMsg("message string");
      messageBarHandlerTest.getMsg();

      // NewContactHandler methods
      newContactHandlerTest.newContactButtonPress();
      // all other functions of NewContactHandler are private
      // helper functions of this

      // SearchHandler methods
      searchHandlerTest.searchButtonPress();
      // all other functions of SearchHandler are private
      // helper functions of this

      // TableHandler methods
      tableHandlerTest.initializeTable();
      tableHandlerTest.refresh();
      tableHandlerTest.setTableContents(new ArrayList<>());
      tableHandlerTest.getTableContents();

      //finished
      System.out.println("Finished running skeleton test");

      //  Output:
      /*
      Finished running skeleton test
       */
  }

  /**
   * Gets user interface object
   *
   * @return Ui: User Interface object. May be GUI or TUI
   */
  public Ui getUi() {
    return ui;
  }

  /**
   * Sets User Interface Object
   *
   * @param ui: User Interface object. May be GUI or TUI
   */
  public void setUi(Ui ui) {
    this.ui = ui;
  }

  /**
   * Gets currently active rolodex object
   *
   * @return IRolodex: Active IRolodex object
   */
  public IRolodex getRolodex() {
    return rolodex;
  }

  /**
   * Sets active rolodex object to new IRolodex
   *
   * @param rolodex: New Rolodex object to be used
   */
  public void setRolodex(IRolodex rolodex) {
    this.rolodex = rolodex;
  }

  /**
   * gets runtime args main method was called with
   * @return runtime args String[] array
   */
  public String[] getRuntimeArgs() {
    return runtimeArgs;
  }

  /**
   * builds rolodex object with information from settings
   *
   * @return IRolodex: Created rolodex object
   */
  private IRolodex buildRolodex() {
    // placeholder: should check settings for the last save,
    // and load that if possible. If none exists, or error is raised,
    // construct new
    return new Rolodex(contactsFile);
  }

  /**
   * builds user interface based on information in settings
   *
   * @return Ui: User Interface object
   */
  private Ui buildUi() {
    return new Gui(this); //placeholder.
    // Should first check settings for type of GUI
  }

  /**
   * creates contacts File object to be stored and
   * used for saving and loading data
   * @return File to save to and load from.
     */
  private File buildContactsFile() {
      // File does not accept a default constructor call.
    return new File(this.getClass().getClassLoader().getResource("contacts.ser").getPath());
  }
}