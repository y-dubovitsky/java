package GUI.widget;

import javax.swing.*;
import java.awt.image.ImageObserver;
import java.awt.*;
import java.net.URL;

/**
 * This class implement Image
 */
public class Picture extends JPanel{

    private Image image;
    private  int x;
    private  int y;
    private final String description = "picture";

    /**
     * Create new widget with pictures
     * @param location - resource location
     */
    public Picture(int x, int y, String location) {
        //TODO This is noе universally solution!
        // remove this: new ImageIcon
        this.image = new ImageIcon(
                // inner method invoke
                this.getPath(location),
                this.description).getImage();
    }

    /**
     * This method returns the path to the resource using reflection
     * @param resourceName
     */
    public URL getPath(String resourceName) {
        URL result = this.getClass().getResource(resourceName);
        return result;
    }

    /**
     * Method for draw image
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Нужно узнать что делает этот интерфейс
        g.drawImage(this.image, x, y, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
