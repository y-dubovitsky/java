package GUI.linker;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * This class demonstration how working linker(компановщик)
 */
public class Button1 {

    public static void main(String[] args) {
        Button1 b = new Button1();
        b.setPlace();
    }

    /**
     * Creating frame and panel; Placing panel with button on the frame;
     */
    public void setPlace() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font bigFont = new Font("serif", Font.BOLD, 32);
        JButton jButton = new JButton("Button");
        jButton.setFont(bigFont);
        jFrame.getContentPane().add(BorderLayout.NORTH,  new JButton());
        jFrame.getContentPane().add(BorderLayout.EAST, new JButton());
        jFrame.getContentPane().add(BorderLayout.WEST,  new JButton());
        jFrame.getContentPane().add(BorderLayout.SOUTH,  new JButton());
        jFrame.getContentPane().add(BorderLayout.CENTER,  new JButton());
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
    }
}
