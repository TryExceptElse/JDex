package io.github.tryexceptelse.jdex.fe.gui;

import io.github.tryexceptelse.jdex.JDex;
import io.github.tryexceptelse.jdex.fe.Ui;

/**
 * Graphic User Interface. Extends Ui.
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
     */
    public Gui(JDex jdex){
        this.jdex = jdex;
        runtimeArgs = jdex.getRuntimeArgs();
        appWindow = new AppWindow(jdex);
    }

    /**
     * method that should be called in a loop by main to get user input.
     * @param runtimeArgs: Runtime args which the program was called with
     */
    public void run(String[] runtimeArgs) {
        // placeholder.
        // this may actually not be needed for GUI depending on final
        // implementation, but it is required for a potential TUI.
    }
}
