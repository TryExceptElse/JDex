
package io.github.tryexceptelse.jdex;

import io.github.tryexceptelse.jdex.fe.Ui;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import io.github.tryexceptelse.jdex.fe.gui.AppWindow;
import io.github.tryexceptelse.jdex.fe.gui.Gui;
import io.github.tryexceptelse.jdex.be.Contact;
import io.github.tryexceptelse.jdex.be.Dex;

/**
 * Placeholder java file with imports to test that Maven handles dependencies properly
 *
 * project notes:
 * SDK version 1.8
 *
 */
public class JDex {

  /**
   * Placeholder main
   */

  private Ui ui;
  private Settings settings;
  private Dex dex; // should be imported from backend once available

  /**
   * Constructor for JDex main class.
   * Builds JDex object and gets it ready to be run by main loop
   */
  public JDex(){} //skeleton

  /**
   * Constructs a JDex main object and calls it in the main loop
   * @param args: Runtime args
   */
  public static void main(String[] args) {
      // Skeleton test
      JDex jDexTest = new JDex();
      Settings testSettings = new Settings();
      Contact testContact = new Contact();
      Dex testDex = new Dex();
      Gui testGui = new Gui(jDexTest);
      MainCont testMainCont = new MainCont();
      AppWindow testAppWindow = new AppWindow();

      jDexTest.setDex(testDex);
      jDexTest.getDex();
      jDexTest.setSettings(testSettings);
      jDexTest.getSettings();
      jDexTest.setUi(testGui);
      jDexTest.getUi();
      jDexTest.buildDex();
      jDexTest.buildSettings();
      jDexTest.buildUi();

      testSettings.setAutoSaveLoc("test/location/a");
      testSettings.getAutoSaveLoc();
      testSettings.setDefaultSaveLoc("test/location/b");
      testSettings.getDefaultSaveLoc();
      testSettings.setLastSavedFile("test/location/c");
      testSettings.getLastSavedFile();

      testContact.setFirst("first");
      testContact.getFirst();
      testContact.setLast("last");
      testContact.getLast();
      testContact.setEmail("email string");
      testContact.getEmail();
      testContact.setStreetAddr("address");
      testContact.getstreetAddr();
      testContact.setPhoneNumber("phone");
      testContact.getPhoneNumber();
      testContact.setNotes("note");
      testContact.getNotes();

      testDex.getList();
      testDex.addContact("first", "last", "email", "street address", "phone", "note");
      testDex.save("save address");
      testDex.load("load address");
      testDex.search("first", "last", "email", "street address", "phone");

      testGui.run(args);

      testMainCont.newDex();
      testMainCont.save();
      testMainCont.saveAs();
      testMainCont.load();

      System.out.println("Skeleton test completed");
  }

  /**
   * Gets user interface object
   * @return Ui: User Interface object. May be GUI or TUI
   */
  public Ui getUi() {
    return ui;
  }

  /**
   * Sets User Interface Object
   * @param ui: User Interface object. May be GUI or TUI
   */
  public void setUi(Ui ui) {
    this.ui = ui;
  }

  /**
   * Gets settings object used by main
   * @return Settings: Active program settings
   */
  public Settings getSettings() {
    return settings;
  }

  /**
   * Sets program settings
   * @param settings: New settings object to be used by program
   */
  public void setSettings(Settings settings) {
    this.settings = settings;
  }

  /**
   * Gets currently active rolodex object
   * @return IDex: Active IDex object
   */
  public Dex getDex() {
    return dex;
  }

  /**
   * Sets active rolodex object to new IDex
   * @param dex: New Rolodex object to be used
   */
  public void setDex(Dex dex) {
    this.dex = dex;
  }

  /**
   * builds settings object from config file
   * @return Settings: Settings object
   */
  private Settings buildSettings(){
    // placeholder: final version should try to load settings from file,
    // if that fails, then construct default.
    return new Settings();
  }

  /**
   * builds rolodex object with information from settings
   * @return IDex: Created rolodex object
   */
  private Dex buildDex() {
    // placeholder: should check settings for the last save,
    // and load that if possible. If none exists, or error is raised,
    // construct new
    return new Dex();
  }

  /**
   * builds user interface based on information in settings
   * @return Ui: User Interface object
   */
  private Ui buildUi(){
    return new Gui(this); //placeholder.
      // Should first check settings for type of GUI
  }

}
