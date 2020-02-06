package GUI.simple;

import javax.swing.*;

public class SimpleGUI {

    /**
     * Name of button
     */
    private static String name = "Button";

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JButton jButton = new JButton(name);

        // add button on frame
        jFrame.getContentPane().add(jButton);
        jFrame.setSize(100, 100);
        jFrame.setVisible(true);
    }
}
