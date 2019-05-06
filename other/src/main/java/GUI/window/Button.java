package GUI.window;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Button class; uses composition.
 */
public class Button extends JButton {

    private JButton jButton;

    /**
     * Constructor
     * @param name
     */
    public Button(String name) {
        jButton = new JButton(name);
    }

    /**
     * Getter
     * @return
     */
    public JButton getjButton() {
        return this.jButton;
    }

    /**
     * In this method adding Listener.
     * @param actionListener
     */
    public void addListener(ActionListener actionListener) {
        jButton.addActionListener(actionListener);
    }
}
