package GUI.linker;

import javax.swing.*;
import java.awt.*;

public class Panel1 {

    public static void main(String[] args) {
        Panel1 p = new Panel1();
        p.setPlace();
    }

    public void setPlace() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();

        // set background and add button on the panel
        jPanel.setBackground(new Color(14,54,123));

        // change linker on the panel
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(new JButton("Push me!"));
        jPanel.add(new JButton("Satisfaction!"));
        jFrame.getContentPane().add(BorderLayout.EAST, jPanel);

        // setting jFrame
        jFrame.setSize(300,300);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

}
