package GUI.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea implements ActionListener {

    JFrame jFrame;
    JTextArea jTextArea;

    public TextArea() {
        this.jFrame = new JFrame();
        // settings
        this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.jFrame.setSize(500,500);
        this.jFrame.setVisible(true);
        this.jTextArea = new JTextArea();
    }

    public static void main(String[] args) {
        TextArea textArea = new TextArea();
        textArea.setTextArea();
    }

    public void setTextArea() {
        JPanel jPanel = new JPanel();

        // create area
        jTextArea.setLineWrap(true);

        // add scroller and settings
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // create Button
        JButton jButton = new JButton("Lets Start");
        jButton.addActionListener(this);

        // add components on the panel
        jPanel.add(BorderLayout.EAST, jButton);
        jPanel.add(BorderLayout.NORTH, jScrollPane);

        // add on frame
        jFrame.add(BorderLayout.CENTER, jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(jTextArea.getText());
    }
}
