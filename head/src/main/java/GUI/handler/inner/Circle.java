package GUI.handler.inner;

import javax.swing.*;
import java.awt.*;

/**
 * StartMoving class
 */
public class Circle extends JComponent {

    private int x;
    private int y;

    /**
     * Constructor
     * @param x - x axis coordinate
     * @param y - y axis coordinate
     */
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draw StartMoving
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        // this
        Graphics2D graphics2D = (Graphics2D)g;
        // TODO do refactoring (float)Math.random() * 10
        graphics2D.setColor(Color.getHSBColor((float)Math.random() * 10, (float)Math.random() * 10, (float)Math.random() * 10));
        graphics2D.drawOval(this.x, this.y, 100, 100);
    }
}
