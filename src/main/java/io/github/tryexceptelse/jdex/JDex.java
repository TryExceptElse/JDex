package io.github.tryexceptelse.jdex;

import io.github.tryexceptelse.jdex.be.Rolodex;
import io.github.tryexceptelse.jdex.fe.Ui;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import io.github.tryexceptelse.jdex.fe.gui.AppWindow;
import io.github.tryexceptelse.jdex.fe.gui.Gui;
import io.github.tryexceptelse.jdex.be.Contact;

import java.util.HashMap;

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
  private Rolodex rolodex; // should be imported from backend once available

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
      Rolodex testRolodex = new Rolodex();
      Gui testGui = new Gui(jDexTest);
      MainCont testMainCont = new MainCont();
      AppWindow testAppWindow = new AppWindow();

      jDexTest.setRolodex(testRolodex);
      jDexTest.getRolodex();
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

      testContact.setKey("testKey", "testValue");
      testContact.getEntry("testKey");

      testRolodex.getList();
      testRolodex.addContact(new HashMap<String, String>(){{
          put("key1", "value1");
      }});
      testRolodex.save("save address");
      testRolodex.load("load address");
      testRolodex.search(new HashMap<String, String>(){{
          put("key1", "value1");
      }});

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
  public Rolodex getRolodex() {
    return rolodex;
  }

  /**
   * Sets active rolodex object to new IDex
   * @param rolodex: New Rolodex object to be used
   */
  public void setRolodex(Rolodex rolodex) {
    this.rolodex = rolodex;
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
  private Rolodex buildDex() {
    // placeholder: should check settings for the last save,
    // and load that if possible. If none exists, or error is raised,
    // construct new
    return new Rolodex();
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
