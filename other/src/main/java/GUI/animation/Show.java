package GUI.animation;

import javax.swing.*;
import java.awt.*;

/**
 * Main class;
 */
public class Show {

    /**
     * Frame
     */
    private JFrame jFrame;

    /**
     * Frame size
     */
    private int x;
    private int y;

    /**
     * Default Constructor
     */
    public Show() {
        this.jFrame = new JFrame();
        jFrame.setSize(500, 500);

        // when we press X button, program is terminated.
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Show(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    /**
     * Add java.awt.Component on Frame;
     */
    public void addOnFrame(String str, JComponent jComponent) {
        jFrame.getContentPane().add(str, jComponent);
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        Show show = new Show();
        Circle circle = new Circle(50,50);
        Label label = new Label();

        //TODO Do BorderLayout.CENTER more flexible
        show.addOnFrame(BorderLayout.CENTER, circle);
        show.addOnFrame(BorderLayout.EAST, label.getJLabel());
        show.addOnFrame(BorderLayout.NORTH,
                new Button(
                        new CircleHandler(circle)).getjButton());
        show.addOnFrame(BorderLayout.SOUTH,
                new Button(
                        new CircleHandler(label)).getjButton());
    }
}
