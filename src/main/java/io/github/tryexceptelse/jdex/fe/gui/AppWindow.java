package io.github.tryexceptelse.jdex.fe.gui;

import io.github.tryexceptelse.jdex.JDex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader; // to load the fxml file for scene
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static io.github.tryexceptelse.jdex.fe.gui.GuiUtil.iconImage;

/**
 * Application Window setup and layout
 */
public class AppWindow extends Application {
    // JDex needs to be static to pass activeJDex object to Application Thread
    private static JDex activeJDex;
    private FXMLLoader loader;
    private Stage stage;
    private MainCont controller;

    private final String PROGRAM_NAME = "JDex";
    private final String PROGRAM_ICON_PATH = "prog_icon.png";
    private final String welcomeMessage =
            "Welcome to %s, you have %s contacts.";

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
        activeJDex = jdex;
        launch(jdex.getRuntimeArgs());
    }

    /**
     * startup method run when window is launched
     * Unlike init, this method is called in the JavaFx application thread
     * @param primaryStage: Staging for window
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        loader = new FXMLLoader(getClass().getClassLoader().
                getResource("fxml/main_window.fxml"));
        stage = primaryStage;
        Parent root = loader.load(); // load fxml file.
        // set controller obj reference to that instantiated by loader when it loaded fxml file
        controller = loader.getController();
        controller.setApp(this); // pass MainCont instance a reference to the main JDex object.
        controller.createHandlers(); // create handlers now that a reference to this instance exists
        Scene mainScene = new Scene(root, 1024, 512);
        primaryStage.setScene(mainScene); // primaryStage is the main application window.
        primaryStage.setTitle(PROGRAM_NAME);
        primaryStage.getIcons().add(iconImage(PROGRAM_ICON_PATH));
        primaryStage.show();
        // set welcome message
        setMessage(String.format(welcomeMessage,
                PROGRAM_NAME, activeJDex.getRolodex().getContacts().size()));
        // set close event
        primaryStage.setOnCloseRequest(event -> // on close request, save dex.
                activeJDex.getRolodex().saveContacts());
    }

    /**
     * Set GUI feedback message to user.
     * This message is visible at the bottom of the GUI window,
     * beneath the table.
     * This method is called by different gui handler objects to
     * provide feedback to the user.
     */
    public void setMessage(String msg){
        controller.setMessage(msg);
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
