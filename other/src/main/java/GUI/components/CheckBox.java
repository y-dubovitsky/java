package GUI.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBox implements ItemListener {

    JFrame jFrame;
    JCheckBox jCheckBox;

    public CheckBox() {
        // settings
        jFrame = new JFrame();
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        CheckBox checkBox = new CheckBox();
        checkBox.setCheckBox();
    }

    public void setCheckBox() {
        this.jCheckBox = new JCheckBox("true or false?");
        this.jCheckBox.addItemListener(this);
        this.jFrame.add(BorderLayout.CENTER, this.jCheckBox);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (this.jCheckBox.isSelected()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
