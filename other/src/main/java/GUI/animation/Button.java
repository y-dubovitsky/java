package GUI.animation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends JComponent {

    private JButton jButton;

    public Button(ActionListener actionListener) {
        this.jButton = new JButton("Do it");
        this.jButton.addActionListener(actionListener);
    }

    public JButton getjButton() {
        return this.jButton;
    }
}
