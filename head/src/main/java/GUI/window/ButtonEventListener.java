package GUI.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class handles events.
 */
public class ButtonEventListener implements ActionListener {

    private Component component;

    public ButtonEventListener(Component component) {
        if (component != null) {
            this.component = component;
        } else {
            System.out.println("null");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO Это не универсально!
        if (this.component instanceof JButton) {
            ((JButton) this.component).setText("Hello");
        }
        this.component.repaint();
    }
}
