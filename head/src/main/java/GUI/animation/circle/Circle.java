package GUI.animation.circle;

import javax.swing.*;
import java.awt.*;

/**
 * Circle class
 */
public class Circle extends JComponent {

    /**
     * Parameters of circle
     */
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Getters ans Setters
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Constructor
     */
    public Circle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * This method draw circle
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(x,y,width,height);
    }
}
