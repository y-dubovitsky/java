package GUI.animation;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionListener;

//TODO NOT WIRK!
/**
 * Wrapper for Label
 */
public class Label extends JComponent {

    JLabel jLabel;
    Utils utils = new Utils();

    public Label() {
        this.jLabel = new JLabel(utils.getText("/text.txt"));
    }

    /**
     * Getter
     * @return
     */
    public JLabel getJLabel() {
        return jLabel;
    }

    /**
     * Draw Circle
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        this.jLabel.setVisible(false);
        this.jLabel.setText(this.utils.getText("/text.txt"));
        this.jLabel.repaint();
    }
}
