package GUI.animation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class handles events
 */
public class CircleHandler implements ActionListener {

    /**
     * JComponent
     */
    JComponent jComponent;

    public CircleHandler(JComponent jComponent) {
        this.jComponent = jComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Visible - invisible
        if (this.jComponent.isVisible()) {
            this.jComponent.setVisible(false);
        } else {
            this.jComponent.setVisible(true);
        }
        // repaint
        this.jComponent.repaint();
    }
}
