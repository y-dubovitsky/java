package GUI.widget;

import javax.swing.*;
import java.awt.*;

/**
 * Figure with color gradient
 */
public class GradientFigure extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        // cast
        Graphics2D g2 = (Graphics2D)g;

        GradientPaint gradientPaint = new GradientPaint(70, 70, Color.BLUE, 150, 150, Color.RED);
        g2.setPaint(gradientPaint);
        g2.fillOval(100,100, 100, 100);
    }
}
