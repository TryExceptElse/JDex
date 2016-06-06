package io.github.tryexceptelse.jdex.fe.gui;

import io.github.tryexceptelse.jdex.JDex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader; // to load the fxml file for scene
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Application Window setup and layout
 */
public class AppWindow extends Application {
    // JDex needs to be static to pass activeJDex object to Application Thread
    private static JDex activeJDex;
    private FXMLLoader loader;
    private Stage stage;
    private MainCont controller;

    /**
     * Default constructor for AppWindow. Does nothing at all.
     * If this is not present, Application thread will crash.
     */
    public AppWindow(){} // this is required for initializing additional threads.
    // note: I'm not sure why the app thread can't simply use the builtin
    // default constructor. If anyone knows, leave a comment or message?

    /**
     * Standard constructor for AppWindow.
     * This method is not called in the app thread, so should not create or
     * add stages or thread dependant objects
     * @param jdex: main jdex object.
     */
    public AppWindow(JDex jdex){
        // skeleton placeholder
    }

    /**
     * startup method run when window is launched
     * Unlike init, this method is called in the main application thread
     * @param primaryStage: Staging for window
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        // skeleton placeholder.
    }

    /**
     * Set GUI feedback message to user.
     */
    public void setMessage(String msg){
        // skeleton placeholder
        // should call MainCont's method of similar name.
    }

    /**
     * gets Application stage object
     */
    public Stage getStage(){
        return stage;
    }

    /**
     * gets Main Controller
     * @return MainCont Main Controller
     */
    public MainCont getController(){
        return controller;
    }

    /**
     * gets JDex main object
     * @return JDex main object
     */
    public JDex getJDex(){
        return activeJDex;
    }
}
