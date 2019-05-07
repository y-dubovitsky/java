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

        // one button
        Button button = new Button("Кнопка");
        button.addListener(new ButtonEventListener(frame.getjFrame()));

        // two button
        Button button1 = new Button("Кнопка");
        button1.addListener(new ButtonEventListener(button1.getjButton()));

        // one Listener
        frame.addWidgets(BorderLayout.CENTER, new RectWidget());
        frame.addWidgets(BorderLayout.EAST, button.getjButton());

        // two Listener
        frame.addWidgets(BorderLayout.NORTH, new RectWidget());
        frame.addWidgets(BorderLayout.SOUTH, button1.getjButton());
    }
}
