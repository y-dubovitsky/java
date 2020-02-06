package GUI.window;

import javax.swing.*;
import java.awt.*;

/**
 * Simple round widget
 */
public class RectWidget extends JPanel {

    /**
     * Rectangle parameters.
     */
    private int x;
    private int y;
    private int w;
    private int h;
    private int theta;

    public RectWidget(int x, int y, int w, int h, int theta) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.theta = theta;
    }

    public RectWidget() {
        this(50,50,100,100, 100);
    }

    /**
     * Random color generator;
     * @return
     */
    public Color getColor() {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        return new Color(r,g,b);
    }

    /**
     * Draw widget
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.getColor());

        // TODO refactoring rotate
        g2.rotate(Math.random());
        g2.fillRect(x,y,w,h);
    }
}
