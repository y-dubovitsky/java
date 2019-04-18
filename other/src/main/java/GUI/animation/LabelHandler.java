package GUI.animation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelHandler implements ActionListener {

    JLabel jLabel;
    Utils utils = new Utils();

    public LabelHandler(JComponent jLabel) {
        //TODO bad solution
        this.jLabel = (JLabel) jLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jLabel.setVisible(false);
        this.jLabel.setText(this.utils.getText("/text.txt"));
        this.jLabel.repaint();
    }
}
