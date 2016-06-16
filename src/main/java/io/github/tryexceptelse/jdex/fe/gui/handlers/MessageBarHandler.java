package io.github.tryexceptelse.jdex.fe.gui.handlers;

import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import javafx.scene.control.Label;

/**
 * Message bar handler to provide feedback to user on results of their
 * actions, etc
 * The message bar resides beneath the Contact Table in the GUI, and is updated
 * by different handlers (via calling setFeedbackMessage(String)) when events
 * occur in order to present status information to the user.
 */
public class MessageBarHandler extends Handler{
    private Label messageLabel;

    /**
     * Message Bar Handler constructor.
     * @param controller: Main Controller object which created this object.
     */
    public MessageBarHandler(MainCont controller){
        super(controller);
        messageLabel = controller.messageLabel;
    }

    /**
     * Sets message which is displayed to user.
     * @param msg String of message to be displayed.
     */
    public void setMsg(String msg){
        messageLabel.setText(msg);
    }

    /**
     * Gets currently displayed message.
     * @return String of message.
     */
    public String getMsg(){
        return messageLabel.getText();
    }
}
