package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.JDex;
import io.github.tryexceptelse.jdex.fe.gui.AppWindow;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        this.controller = controller;
        app = controller.getApp();
        jDex = app.getJDex();
    }

    /**
     * toString raises notImplemented error because it shouldn't be called in
     * production.
     */
    public String toString(){
        throw new NotImplementedException();
    }
}
