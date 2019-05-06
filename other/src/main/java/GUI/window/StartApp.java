package GUI.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartApp {

    /**
     * Test method
     * @param args
     */
    public static void main(String[] args) {
        Frame frame = new Frame(500, 500);
        Button button = new Button("Кнопка");
        button.addListener(new ButtonEventListener(frame.getjFrame()));

        // one and more Listener
        frame.addWidgets(BorderLayout.CENTER, new RectWidget());
        frame.addWidgets(BorderLayout.EAST, button.getjButton());
    }
}
