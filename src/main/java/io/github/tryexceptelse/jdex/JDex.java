
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
      new JDex(args);
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
   * builds rolodex object
   *
   * @return IRolodex: Created rolodex object
   */
  private IRolodex buildRolodex() {
    return new Rolodex(contactsFile);
  }

  /**
   * builds user interface
   *
   * @return Ui: User Interface object
   */
  private Ui buildUi() {
    return new Gui(this); //placeholder.
  }

  /**
   * creates contacts File object to be stored and
   * used for saving and loading data
   * @return File to save to and load from.
     */
  private File buildContactsFile() {
      // File does not accept a default constructor call.
    return new File(this.getClass().getClassLoader().
            getResource("contacts.ser").getPath());
  }
}
