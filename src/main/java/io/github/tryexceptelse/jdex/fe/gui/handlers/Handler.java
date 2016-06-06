package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.JDex;
import io.github.tryexceptelse.jdex.fe.gui.AppWindow;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;

/**
 * Abstract Handler class, from which other handlers inherit.
 */
abstract class Handler {
    JDex jDex;
    AppWindow app;
    MainCont controller;

    /**
     * Default constructor. Required for inheritance
     */
    Handler(){}

    /**
     * Constructor which sets references to other objects in program
     * @param controller: Main Controller for GUI which created this object
     */
    Handler(MainCont controller){
        // skeleton placeholder.
    }
}
