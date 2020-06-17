package GUI.window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    Frame frame;

    @BeforeEach
    void init() {
        frame = new Frame(300, 300);
    }

    @Test
    void addWidgets() {
        JButton jButton = new JButton("Button");
        frame.addWidgets(BorderLayout.EAST, jButton);
    }
}