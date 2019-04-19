package GUI.animation.circle;

import javax.swing.*;
import java.awt.*;

/**
 * StartMoving movement animation
 */
public class StartMoving {

    /**
     * Frame parameters
     */
    private JFrame jFrame;
    private int x;
    private int y;

    /**
     * Object Figure
     */
    private Circle circle;

    /**
     * Constructor
     */
    public StartMoving(int x, int y, Circle j) {
        this.x = x;
        this.y = y;
        jFrame = new JFrame();
        jFrame.setSize(x, y);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.circle = j;
        // add figure on frame
        jFrame.getContentPane().add(BorderLayout.CENTER, this.circle);
    }

    /**
     * Starting moving figure
     */
    public void start() {
        //TODO Доделать Анимацию
        // increment figure coordinate by 1
        if (this.circle.getX() < 0 || this.circle.getY() < 0) {
            x = 1;
            y = 1;
        }
        if (this.circle.getX() >= 500 || this.circle.getY() >= 500) {
            x = -1;
            y = -1;
        }
        this.circle.setX(this.circle.getX() + x);
        this.circle.setY(this.circle.getY() + y);
        // repaint figure
        this.circle.repaint();
    }

    /**
     * Main method
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        StartMoving startMoving = new StartMoving(500, 500, new Circle(50,50,50,50));
        while (true){
            startMoving.start();
            Thread.sleep(10);
        }
    }
}
