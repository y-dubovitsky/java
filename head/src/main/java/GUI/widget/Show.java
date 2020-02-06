package GUI.widget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Show {

    /**
     * List of components
     */
    List<JComponent> componentList = new ArrayList<>();

    /**
     * JFrame
     */
    private JFrame jFrame = new JFrame();

    /**
     * Size of JFrame. Length and height
     */
    private int x;
    private int y;

    /**
     * Default constructor
     */
    public Show() {

    }

    /**
     * Setter of JFrame
     * @param x - x size
     * @param y - y size
     */
    public void setSize(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This method add components in list.
     * @param jComponent
     */
    public void addComponents(JComponent jComponent) {
        // add new component on frame
        this.componentList.add(jComponent);
    }

    /**
     * In this method drawing all components on JFrame
     */
    // TODO make it more flexible
    public void draw() {

        // Where to place components
        String[] borders = new String[]{
                BorderLayout.CENTER,
                BorderLayout.NORTH,
                BorderLayout.EAST,
                BorderLayout.SOUTH
        };

        // draw a frame of a certain size
        this.jFrame.setSize(x,y);
        for (int i = 0; i < this.componentList.size(); i++) {
            this.jFrame
                    .getContentPane()
                    .add(
                            borders[i],
                            this.componentList.get(i)
                    );
        }
        // make Frame visible
        this.jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Show show = new Show();
        show.setSize(500,500);
        show.addComponents(new Rect());
        show.addComponents(new Rect(20,30,40,50));
        show.addComponents(new Picture(10, 20, "/lion.png"));
        show.addComponents(new GradientFigure());
        show.draw();
    }
}
