package GUI.handler;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Objects of this class act as event sources.
 */
public class ActionSource {

    JFrame jFrame;
    JButton jButton;

    /**
     * Listener
     */
    ActionListener listener;

    public ActionSource(ActionListener actionListener) {
        this.jFrame = new JFrame();
        this.jButton = new JButton("Click me");
        this.jFrame.add(this.jButton);

        //TODO
        this.listener = actionListener;
        // Registration as Listener.
        this.jButton.addActionListener(this.listener);

        this.jFrame.setSize(300,300);
        this.jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ActionSource actionSource = new ActionSource(new Listener());
    }
}
