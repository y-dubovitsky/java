package GUI.window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class contain widget objects.
 */
public class Frame {

    private JFrame jFrame = new JFrame();
    private ArrayList<Component> listComponent = new ArrayList<>();

    /**
     * JFrame settings
     */
    public Frame(int x, int y) {
        jFrame.setSize(x,y);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Getter
     * @return
     */
    public JFrame getjFrame() {
        return jFrame;
    }

    /**
     * Adding components on frame.
     * @param jComponent
     */
    public void addWidgets(String layout, Component jComponent) {
        this.listComponent.add(jComponent);
        this.jFrame.getContentPane().add(layout, jComponent);
    }
}
