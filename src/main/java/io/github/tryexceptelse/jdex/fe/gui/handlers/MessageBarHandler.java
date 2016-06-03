package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import javafx.scene.control.Label;

import java.sql.Time;

/**
 * Message bar handler to provide feedback to user on results of their
 * actions, etc
 */
public class MessageBarHandler extends Handler{
    private Label messageLabel;
    private Time timeMessageSet; // time at which current message was set
    // this is used for determining when to return to default message bar.

    /**
     * Message Bar Handler constructor.
     * @param controller: Main Controller object which created this object.
     */
    public MessageBarHandler(MainCont controller){
        super(controller);
        // skeleton placeholder
    }

    /**
     * Sets message which is displayed to user.
     * @param msg String of message to be displayed.
     */
    public void setMsg(String msg){
        // placeholder. Should set GUI Label object (from Javafx.)
    }

    /**
     * Gets currently displayed message.
     * @return String of message.
     */
    public String getMsg(){
        // skeleton placeholder. Should get message from GUI Label object.
        // (From Javafx)
        return "placeholder message";
    }
}
