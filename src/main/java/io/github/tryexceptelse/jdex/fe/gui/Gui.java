package io.github.tryexceptelse.jdex.fe.gui;

import io.github.tryexceptelse.jdex.JDex;
import io.github.tryexceptelse.jdex.fe.Ui;

/**
 * Graphic User Interface. extends Ui.
 * Gets user input and calls appropriate methods.
 */
public class Gui implements Ui {

    private JDex jdex;
    private AppWindow appWindow;
    private String[] runtimeArgs;

    /**
     * Constructor for Gui, should leave object in a state ready to be called
     * This method initializes an AppWindow
     * @param jdex: main class which is running the ui.
     * @param runtimeArgs: args passed at runtime to program
     */
    public Gui(JDex jdex, String[] runtimeArgs){}

    /**
     * method that should be called in a loop by main to get user input.
     * @param args: runtime args
     */
    public void run(String[] args) {}
}
