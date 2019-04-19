package GUI.animation;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main class;
 */
public class Show {

    /**
     * Frame
     */
    private JFrame jFrame;
    private JLabel jLable;
    private Circle circle;

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

    public void go() {
        JButton lableButton = new JButton("Change label");
        lableButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        jLable = new JLabel("Label");
        circle = new Circle(50,50);

        jFrame.getContentPane().add(BorderLayout.EAST, lableButton);
        jFrame.getContentPane().add(BorderLayout.NORTH, colorButton);
        jFrame.getContentPane().add(BorderLayout.WEST, jLable);
        jFrame.getContentPane().add(BorderLayout.CENTER, circle);
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        Show show = new Show();
        show.go();
    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jLable.setText(new Utils().getText());
        }
    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Visible - invisible
            if (circle.isVisible()) {
                circle.setVisible(false);
            } else {
                circle.setVisible(true);
            }
            // repaint
            circle.repaint();
        }
    }
}
