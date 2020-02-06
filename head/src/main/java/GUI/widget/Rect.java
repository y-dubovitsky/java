package GUI.widget;

import javax.swing.*;
import java.awt.*;

/**
 * This class implement Rectangle
 */
public class Rect extends JPanel {

    /**
     * Parameters of Rectangle
     */
    private int x = 100;
    private int y = 100;
    private int width = 50;
    private int height = 50;

    /**
     * Default constructor
     */
    public Rect() {

    }

    /**
     * Constructor
     */
    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    /**
     * Only this method must to implements, to draw figure.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.draw3DRect(this.x, this.y, this.width, this.height, true);
    }
}
