package GUI.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class show how to use various GUI components
 */
public class Text {

    JFrame jframe;

    public Text() {
        this.jframe = new JFrame();
        // settings
        this.jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.jframe.setSize(500,500);
        this.jframe.setVisible(true);
    }

    public static void main(String[] args) {
        Text c = new Text();
        c.setComponent();
    }

    public void setComponent() {
        // set textField
        TextField textField = new TextField(30);
        // add listener
        textField.addActionListener(new TextListener());
        // TODO Можно добавить панель, а на панели уже разместить компоненты
        this.jframe.getContentPane().add(BorderLayout.EAST, textField);
    }

    /**
     * This class processing user action;
     */
    class TextListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String userText = e.getActionCommand();
            System.out.println(userText);
        }
    }
}
